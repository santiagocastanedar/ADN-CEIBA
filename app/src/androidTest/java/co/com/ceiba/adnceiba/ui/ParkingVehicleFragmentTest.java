package co.com.ceiba.adnceiba.ui;

import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.ScrollView;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.PickerActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import co.com.ceiba.adnceiba.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ParkingVehicleFragmentTest {


    @Rule
    public ActivityScenarioRule<MainMenuActivity> mActivityTestRule = new ActivityScenarioRule<>(MainMenuActivity.class);

    @Test
    public void saveCarTest(){
        onView(withId(R.id.buttonAddVehicle)).perform(click());
        onView(withId(R.id.editTextPlate)).perform(typeText("FGU249"),closeSoftKeyboard());
        onView(withId(R.id.radioButtonCar)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).
                perform(PickerActions.setDate(2021, 05, 07));
        onView(withId(R.id.buttonCreateVehicle)).perform(click());
    }

    @Test
    public void saveMotorcycleTest(){
        onView(withId(R.id.buttonAddVehicle)).perform(click());
        onView(withId(R.id.editTextPlate)).perform(typeText("FGU567"));
        onView(withId(R.id.radioButtonMotorcycle)).perform(click());
        onView(withId(R.id.editTextCylinder)).perform(typeText(""));
        onView(withId(R.id.editTextCylinder)).perform(typeText("750"),closeSoftKeyboard());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).
                perform(PickerActions.setDate(2021, 07, 04));
        onView(withId(R.id.buttonCreateVehicle)).perform(click()).perform(scrollTo());
    }

}