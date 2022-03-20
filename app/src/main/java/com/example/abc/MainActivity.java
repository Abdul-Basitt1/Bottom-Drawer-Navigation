package com.example.abc;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.abc.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import com.example.abc.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private TextView previousCalculation;
    private EditText display;
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        display = findViewById(R.id.displayEditText);
        display.setShowSoftInputOnFocus(false);
        previousCalculation = findViewById(R.id.previousCalculationView);
        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        BottomNavigationView bottom_nav_view= findViewById(R.id.bottom_nav_view);
        NavigationUI.setupWithNavController(bottom_nav_view, navController);

        bottom_nav_view.setItemIconTintList(null);


        }



    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursorPos + strToAdd.length());
    }

    public void zeroBTNPush(View view){

        updateText(getResources().getString(R.string.zeroText));
    }

    public void oneBTNPush(View view){

        updateText(getResources().getString(R.string.oneText));
    }

    public void twoBTNPush(View view){

        updateText(getResources().getString(R.string.twoText));
    }

    public void threeBTNPush(View view){
        updateText(getResources().getString(R.string.threeText));
    }

    public void fourBTNPush(View view){

        updateText(getResources().getString(R.string.fourText));
    }

    public void fiveBTNPush(View view){

        updateText(getResources().getString(R.string.fiveText));
    }

    public void sixBTNPush(View view){

        updateText(getResources().getString(R.string.sixText));
    }

    public void sevenBTNPush(View view){
        updateText(getResources().getString(R.string.sevenText));
    }

    public void eightBTNPush(View view){
        updateText(getResources().getString(R.string.eightText));
    }

    public void nineBTNPush(View view){

        updateText(getResources().getString(R.string.nineText));
    }

    public void multiplyBTNPush(View view){
        updateText(getResources().getString(R.string.multiplyText));
    }

    public void divideBTNPush(View view){
        updateText(getResources().getString(R.string.divideText));
    }

    public void subtractBTNPush(View view){
        updateText(getResources().getString(R.string.subtractText));
    }

    public void addBTNPush(View view){

        updateText(getResources().getString(R.string.addText));
    }

    public void clearBTNPush(View view){
        display.setText("");
        previousCalculation.setText("");
    }

    public void parOpenBTNPush(View view){
        updateText(getResources().getString(R.string.parenthesesOpenText));
    }

    public void parCloseBTNPush(View view){
        updateText(getResources().getString(R.string.parenthesesCloseText));
    }

    public void decimalBTNPush(View view){
        updateText(getResources().getString(R.string.decimalText));
    }

    public void equalBTNPush(View view){
        String userExp = display.getText().toString();

        previousCalculation.setText(userExp);

        userExp = userExp.replaceAll(getResources().getString(R.string.divideText), "/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiplyText), "*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }

    public void backspaceBTNPush(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }

    public void trigSinBTNPush(View view){

        updateText("sin(");
    }

    public void trigCosBTNPush(View view){

        updateText("cos(");
    }

    public void trigTanBTNPush(View view){

        updateText("tan(");
    }

    public void trigArcSinBTNPush(View view){

        updateText("arcsin(");
    }

    public void trigArcCosBTNPush(View view){

        updateText("arccos(");
    }

    public void trigArcTanBTNPush(View view){

        updateText("arctan(");
    }

    public void naturalLogBTNPush(View view){

        updateText("ln(");
    }

    public void logBTNPush(View view){

        updateText("log(");
    }

    public void sqrtBTNPush(View view){

        updateText("sqrt(");
    }

    public void absBTNPush(View view){

        updateText("abs(");
    }

    public void piBTNPush(View view){

        updateText("pi");
    }

    public void eBTNPush(View view){

        updateText("e");
    }

    public void xSquaredBTNPush(View view){

        updateText("^(2)");
    }

    public void xPowerYBTNPush(View view){

        updateText("^(");
    }

    public void primeBTNPush(View view){

        updateText("ispr(");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}