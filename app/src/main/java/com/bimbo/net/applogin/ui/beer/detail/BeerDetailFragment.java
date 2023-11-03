package com.bimbo.net.applogin.ui.beer.detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bimbo.net.applogin.R;
import com.bimbo.net.applogin.databinding.FragmentBeerBinding;
import com.bimbo.net.applogin.databinding.FragmentBeerDetailBinding;
import com.bimbo.net.applogin.repository.local.model.BeerDetail;
import com.bimbo.net.applogin.ui.beer.MainActivity;
import com.bimbo.net.applogin.ui.beer.list.BeerViewModel;
import com.squareup.picasso.Picasso;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class BeerDetailFragment extends Fragment {

    private FragmentBeerDetailBinding binding;

    private BeerDetailViewmodel viewModel;
    public static BeerDetailFragment newInstance(String param1, String param2) {
        BeerDetailFragment fragment = new BeerDetailFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_beer_detail, container, false);
        viewModel = new ViewModelProvider(this).get(BeerDetailViewmodel.class);
        viewModel.initLocalRepository(requireContext());

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel.getBeerDetailResult().observe(this.getViewLifecycleOwner(),result->{
            switch (result.getStatus().name()){
                case "LOADING":
                    ((MainActivity)requireActivity()).showDialogProgressBar(result.getMessage(), getContext());
                    break;
                case "SUCCESS":
                    ((MainActivity)requireActivity()).hideDialogProgressBar();
                    initviewData(result.getData());
                    break;
                case "ERROR":
                    Toast.makeText(getContext(),"Sin datos en BD local",Toast.LENGTH_LONG).show();
                    ((MainActivity) requireActivity()).hideDialogProgressBar();
                    break;
            }
        });

        Long id = getArguments().getLong("idElement");

        viewModel.getBeerDetailById(id);

    }

    private void initviewData(BeerDetail detail){
        binding.brewersTips.setText(detail.getBrewersTips());
        binding.contributedBy.setText(detail.getContributedBy());
        binding.tvNameBeer.setText(detail.getName());
        binding.tvDescription.setText(detail.getDescription());
        binding.tvContenido.setText(detail.getContent()+" litres");

        Picasso.get()
                .load(detail.getImageUrl())
                .placeholder(R.drawable.ic_beer)
                .error(R.drawable.ic_beer)
                .into(binding.imgBeer);
    }

}