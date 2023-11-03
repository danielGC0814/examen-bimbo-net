package com.bimbo.net.applogin.ui.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bimbo.net.applogin.R;
import com.bimbo.net.applogin.databinding.FragmentLoginBinding;
import com.bimbo.net.applogin.ui.beer.MainActivity;
import com.bimbo.net.applogin.util.SharedPref;


public class LoginFragment extends Fragment {




    LoginViewModel loginViewModel;
    private FragmentLoginBinding binding;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        SharedPref srf= new SharedPref(getContext());
        String name = srf.getNameUser();
        if(name != null && !name.isEmpty()){
            changeViewBeerMain();
        }

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false);
        binding.setLifecycleOwner(getViewLifecycleOwner());

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        if(binding != null){
            binding.btnLogin.setOnClickListener(v -> {
                if(isValidForm()){
                    executeLogin();
                }

            });
        }

        return binding.getRoot();
    }

    public boolean isValidForm(){

        String user = binding.editTextUsername.getText().toString();
        String pwd = binding.editTextPassword.getText().toString();
        if(user==null || user.isEmpty()){
            Toast.makeText(requireContext(),"El usuario es requerido.", Toast.LENGTH_LONG).show();
            return false;
        }

        if(pwd==null || pwd.isEmpty()){
            Toast.makeText(requireContext(),"La contraseña es requerida.", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPref sh = new SharedPref(requireContext());
        String email = sh.getEmailUser();
        binding.editTextUsername.setText(email);
    }

    private void executeLogin(){

        loginViewModel.getLoginResult().observe(this.getViewLifecycleOwner(),result->{
                switch (result.getStatus().name()){
                    case "LOADING":
                        ((LoginActivity)requireActivity()).showDialogProgressBar(result.getMessage(), getContext());
                        break;
                    case "SUCCESS":
                        ((LoginActivity)requireActivity()).hideDialogProgressBar();
                        SharedPref sh = new SharedPref(requireContext());
                        sh.setNameUser(result.getData().getResult().getName());
                        sh.setEmailUser(result.getData().getResult().getEmail());
                        changeViewBeerMain();
                        break;
                    case "ERROR":
                        Toast.makeText(getContext(),result.getMessage(),Toast.LENGTH_LONG).show();
                        ((LoginActivity)requireActivity()).hideDialogProgressBar();
                        break;
                }
        });
        loginViewModel.login(binding.editTextUsername.getText().toString(),
                binding.editTextPassword.getText().toString());
    }

    private void changeViewBeerMain(){
        Intent intent = new Intent(this.getActivity(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

}