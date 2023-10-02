package com.example.projector_booking_app.activities;

import android.os.Bundle;
import android.util.Log;

import com.example.projector_booking_app.R;
import com.example.projector_booking_app.model.Teacher;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.projector_booking_app.databinding.ActivityHomeBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.+


        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_projector, R.id.navigation_notifications, R.id.navigation_reports,R.id.navigation_profile)
                .build();


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_home);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        com.google.firebase.messaging.FirebaseMessaging.getInstance().getToken().addOnSuccessListener(new OnSuccessListener<String>() {
            @Override
            public void onSuccess(String s) {
                if(s!=null){
                    FirebaseDatabase.getInstance().getReference().child("Teachers")
                            .child(FirebaseAuth.getInstance().getUid())
                            .get().addOnSuccessListener(new OnSuccessListener<DataSnapshot>() {
                                @Override
                                public void onSuccess(DataSnapshot dataSnapshot) {

                                    Log.i("fdjfld", FirebaseAuth.getInstance().getCurrentUser().getUid());
                                    Teacher teacher  = dataSnapshot.getValue(Teacher.class);
                                    teacher.setFcmToken(s);
                                    dataSnapshot.getRef().setValue(teacher);
                                }
                            });
                }

            }
        });

    }

}