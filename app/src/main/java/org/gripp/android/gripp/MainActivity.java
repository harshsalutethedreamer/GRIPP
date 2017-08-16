package org.gripp.android.gripp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.gripp.android.gripp.utils.Constants;

public class MainActivity extends AppCompatActivity{

    private Button boiler_feeder_floor,boiling_zero_floor,turbine_zero_floor,turbine_eightpointfive_floor,electrical_operator,signup,share;
    private FirebaseAuth mAuth;
    private TextView greetings;
    protected SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSharedPreferences=getSharedPreferences(Constants.USER_INFO_PREFERENCE, Context.MODE_PRIVATE);

        signup=(Button) findViewById(R.id.signup);
        greetings=(TextView) findViewById(R.id.greetings);
        share=(Button)findViewById(R.id.share);

        mAuth=FirebaseAuth.getInstance();

        boiler_feeder_floor=(Button) findViewById(R.id.boiling_feeder_floor);
        boiler_feeder_floor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,BoilerFiringFloor.class);
                startActivity(i);
            }
        });

        boiling_zero_floor=(Button) findViewById(R.id.boiling_zero_floor);
        boiling_zero_floor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,BoilerZeroFloor.class);
                startActivity(i);
            }
        });

        turbine_zero_floor=(Button) findViewById(R.id.turbine_zero_floor);
        turbine_zero_floor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,TurbineZeroFloor.class);
                startActivity(i);
            }
        });

        turbine_eightpointfive_floor=(Button) findViewById(R.id.turbin_eightpointfive_floor);
        turbine_eightpointfive_floor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,TurbineEightPointFiveFloor.class);
                startActivity(i);
            }
        });

        electrical_operator=(Button) findViewById(R.id.electrical_operator);
        electrical_operator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,ElectricalOperator.class);
                startActivity(i);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,SignInActivity.class);
                startActivity(i);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,ChatActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser=mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser user){

            if(user!=null){
                    signup.setVisibility(View.GONE);
                    greetings.setVisibility(View.VISIBLE);
                    share.setVisibility(View.VISIBLE);

                    String name=user.getDisplayName();
                    mSharedPreferences.edit().putString(Constants.nameofoperator,name).apply();
                    greetings.setText("Welcome "+ name);
                Log.d("checkuserx","exists");
                }else{
                signup.setVisibility(View.VISIBLE);
                    greetings.setVisibility(View.GONE);
                    share.setVisibility(View.GONE);
                }

    }
}
