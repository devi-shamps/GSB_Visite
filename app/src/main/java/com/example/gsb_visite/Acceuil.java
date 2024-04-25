package com.example.gsb_visite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.gsb_visite.databinding.ActivityAcceuilBinding;

import java.util.ArrayList;
import java.util.List;

public class Acceuil extends AppCompatActivity {

    private ActivityAcceuilBinding binding;
    private Visiteur visiteur;
    private RecyclerViewClickListener listener;

    private Praticien praticien;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAcceuilBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        visiteur = (Visiteur) getIntent().getSerializableExtra("visiteur");
        binding.textViewName.setText("Bienvenue " + visiteur.getNom() + ',');


        ArrayList<Praticien> praticiens = new ArrayList<Praticien>();
        praticiens.add(new Praticien("Dr. Dupont", "Jean", "01 02 03 04 06", "pasdidiee@gmail.com", "3 rue proute", "74000", "Annecky"));
        praticiens.add(new Praticien("Dr. Duprout", "Luc", "01 02 60 04 06", "toujourspas@gmail.com", "4 rue proute", "74000", "Annecky"));
        praticiens.add(new Praticien("Dr. Dupont", "Jean", "01 02 03 04 06", "pasdidiee@gmail.com", "3 rue proute", "74000", "Annecky"));
        praticiens.add(new Praticien("Dr. Duprout", "Luc", "01 02 60 04 06", "toujourspas@gmail.com", "4 rue proute", "74000", "Annecky"));
        praticiens.add(new Praticien("Dr. Dupont", "Jean", "01 02 03 04 06", "pasdidiee@gmail.com", "3 rue proute", "74000", "Annecky"));
        praticiens.add(new Praticien("Dr. Duprout", "Luc", "01 02 60 04 06", "toujourspas@gmail.com", "4 rue proute", "74000", "Annecky"));
        praticiens.add(new Praticien("Dr. Dupont", "Jean", "01 02 03 04 06", "pasdidiee@gmail.com", "3 rue proute", "74000", "Annecky"));
        praticiens.add(new Praticien("Dr. Duprout", "Luc", "01 02 60 04 06", "toujourspas@gmail.com", "4 rue proute", "74000", "Annecky"));
        praticiens.add(new Praticien("Dr. Dupont", "Jean", "01 02 03 04 06", "pasdidiee@gmail.com", "3 rue proute", "74000", "Annecky"));
        praticiens.add(new Praticien("Dr. Duprout", "Luc", "01 02 60 04 06", "toujourspas@gmail.com", "4 rue proute", "74000", "Annecky"));
        praticiens.add(new Praticien("Dr. Dupont", "Jean", "01 02 03 04 06", "pasdidiee@gmail.com", "3 rue proute", "74000", "Annecky"));
        praticiens.add(new Praticien("Dr. Duprout", "Luc", "01 02 60 04 06", "toujourspas@gmail.com", "4 rue proute", "74000", "Annecky"));

        binding.recyclerViewPracticien.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        binding.recyclerViewPracticien.setLayoutManager(layoutManager);
        binding.recyclerViewPracticien.setFocusable(false);

        RecyclerAdapter myAdapterProjet = new RecyclerAdapter(praticiens);
        binding.recyclerViewPracticien.setAdapter(myAdapterProjet);

        binding.recyclerViewPracticien.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), binding.recyclerViewPracticien, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getApplicationContext(), "Position " + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Acceuil.this, VisitePraticien.class);
                startActivity(intent);
            }
        }));

    }
}