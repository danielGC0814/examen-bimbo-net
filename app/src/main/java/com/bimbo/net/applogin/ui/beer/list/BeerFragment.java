package com.bimbo.net.applogin.ui.beer.list;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bimbo.net.applogin.R;
import com.bimbo.net.applogin.databinding.FragmentBeerBinding;
import com.bimbo.net.applogin.repository.network.model.beer.BeerResponse;
import com.bimbo.net.applogin.ui.beer.MainActivity;
import com.bimbo.net.applogin.ui.beer.list.adapter.ElementItem;
import com.bimbo.net.applogin.ui.beer.list.adapter.ListAdapterCustom;
import com.bimbo.net.applogin.util.SharedPref;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class BeerFragment extends Fragment {

    private FragmentBeerBinding binding;

    private BeerViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_beer,container,false);
        viewModel = new ViewModelProvider(this).get(BeerViewModel.class);
        viewModel.initLocalRepository(requireContext());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPref sr = new SharedPref(requireContext());
        ((MainActivity)requireActivity()).setNameUserHeader(sr.getNameUser());
        ((MainActivity)requireActivity()).setNameBeer("Beer");
        executeGetBeers();
    }

    private void executeGetBeers(){
        viewModel.getBeerResult().observe(this.getViewLifecycleOwner(),result->{
            switch (result.getStatus().name()){
                case "LOADING":
                    ((MainActivity)requireActivity()).showDialogProgressBar(result.getMessage(), getContext());
                    break;
                case "SUCCESS":
                    ((MainActivity)requireActivity()).hideDialogProgressBar();
                    initRecyclerView(result.getData());
                    break;
                case "ERROR":
                    Toast.makeText(getContext(),result.getMessage(),Toast.LENGTH_LONG).show();
                    ((MainActivity) requireActivity()).hideDialogProgressBar();
                    break;
            }
        });
        viewModel.getBeer();
    }

    private void initRecyclerView(List<BeerResponse> listResponse){

        ListAdapterCustom adapter = new ListAdapterCustom(buildListView( listResponse), (itemSelected,position) -> {
            BeerResponse seletcted =listResponse.get(position);
            changeViewBeerMain(seletcted.getId());
        },getContext());

        binding.lsRcBeers.setHasFixedSize(true);
        binding.lsRcBeers.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.lsRcBeers.setAdapter(adapter);
    }

    private List<ElementItem> buildListView(List<BeerResponse> listResponse){
        List<ElementItem> list = new ArrayList<>();
        listResponse.forEach(item->{
            list.add(new ElementItem(item.getImageUrl(),item.getName(),item.getDescription()));
        });

        return list;
    }

    private void changeViewBeerMain(Long id){
        Bundle bundle = new Bundle();
        bundle.putLong("idElement", id);
        NavHostFragment.findNavController(this)
                .navigate(R.id.action_beerFragment_to_beerDetailFragment,bundle);

    }
}