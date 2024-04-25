package com.example.gsb_visite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Call;

import com.example.gsb_visite.databinding.ActivityLoginBinding;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private Visiteur visiteur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visiteur = new Visiteur();
                visiteur.setEmail(binding.editTextTextEmail.getText().toString());
                visiteur.setPassword(binding.editTextTextPassword.getText().toString());

                gsbServices service = RetrofitClientInstance.getRetrofitInstance().create(gsbServices.class);
                Call<Visiteur> call = service.login(visiteur);


                call.enqueue(new Callback<Visiteur>() {
                    @Override
                    public void onResponse(Call<Visiteur> call, Response<Visiteur> response) {
                        visiteur = response.body();
                        if (visiteur == null) {
                            Toast.makeText(MainActivity.this, "Erreur d'authentification", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Toast.makeText(MainActivity.this, "Bienvenue ", Toast.LENGTH_SHORT).show();

                        getVisiteur();


                    }
                    @Override
                    public void onFailure(Call<Visiteur> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Une erreur est survenue !", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    public void getVisiteur() {
        gsbServices service = RetrofitClientInstance.getRetrofitInstance().create(gsbServices.class);
        Call<Visiteur> call = service.getVisiteur(visiteur.getToken(), visiteur.getVisiteurId());

        call.enqueue(new Callback<Visiteur>() {
            @Override
            public void onResponse(Call<Visiteur> call, Response<Visiteur> response) {
                Visiteur visiteurInfo = response.body();
                Intent intent = new Intent(MainActivity.this, Acceuil.class);
                intent.putExtra("visiteur", visiteurInfo);

                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Visiteur> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Une erreur est survenue lors de la récupération des informations du visiteur !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}