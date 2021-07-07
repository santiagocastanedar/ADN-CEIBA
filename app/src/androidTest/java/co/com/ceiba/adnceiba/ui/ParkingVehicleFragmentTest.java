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
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import co.com.ceiba.adnceiba.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.isDialog;
import static androidx.test.espresso.matcher.RootMatchers.isFocusable;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4.class)
public class ParkingVehicleFragmentTest {


    @Rule
    public ActivityTestRule<MainMenuActivity> mActivityTestRule = new ActivityTestRule<>(MainMenuActivity.class);

    @Test
    public void A_saveCar_correctInformation_true(){
        onView(withId(R.id.buttonAddVehicle)).perform(click());
        onView(withId(R.id.editTextPlate)).perform(typeText("FGJ230"),closeSoftKeyboard());
        onView(withId(R.id.radioButtonCar)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).
                perform(PickerActions.setDate(2021, 05, 07));
        onView(withId(R.id.buttonCreateVehicle)).perform(scrollTo(),click());
        onView(withText(R.string.addCar)).inRoot(isDialog()).check(matches(isDisplayed()));
    }

    @Test
    public void B_saveCar_samePlate_true(){
        onView(withId(R.id.buttonAddVehicle)).perform(click());
        onView(withId(R.id.editTextPlate)).perform(typeText("FGJ230"),closeSoftKeyboard());
        onView(withId(R.id.radioButtonCar)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).
                perform(PickerActions.setDate(2021, 05, 07));
        onView(withId(R.id.buttonCreateVehicle)).perform(scrollTo(),click());
        onView(withText(R.string.vehicleExist)).inRoot(isDialog()).check(matches(isDisplayed()));
    }

    @Test
    public void C_saveCar_incorrectInformation_true(){
        onView(withId(R.id.buttonAddVehicle)).perform(click());
        onView(withId(R.id.editTextPlate)).perform(typeText(""),closeSoftKeyboard());
        onView(withId(R.id.radioButtonCar)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).
                perform(PickerActions.setDate(2021, 05, 07));
        onView(withId(R.id.buttonCreateVehicle)).perform(scrollTo(),click());
        onView(withText(R.string.incorrectPlate)).inRoot(isDialog()).check(matches(isDisplayed()));
    }

    @Test
    public void D_saveMotorcycle_correctInformation_true(){
        onView(withId(R.id.buttonAddVehicle)).perform(click());
        onView(withId(R.id.editTextPlate)).perform(typeText("DFG456"));
        onView(withId(R.id.radioButtonMotorcycle)).perform(click());
        onView(withId(R.id.editTextCylinder)).perform(typeText(""));
        onView(withId(R.id.editTextCylinder)).perform(typeText("750"),closeSoftKeyboard());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).
                perform(PickerActions.setDate(2021, 07, 04));
        onView(withId(R.id.buttonCreateVehicle)).perform(scrollTo(),click());
        onView(withText(R.string.addMotorcycle)).inRoot(isDialog()).check(matches(isDisplayed()));
    }

    @Test
    public void E_saveMotorcycle_samePlate_true(){
        onView(withId(R.id.buttonAddVehicle)).perform(click());
        onView(withId(R.id.editTextPlate)).perform(typeText("DFG456"));
        onView(withId(R.id.radioButtonMotorcycle)).perform(click());
        onView(withId(R.id.editTextCylinder)).perform(typeText(""));
        onView(withId(R.id.editTextCylinder)).perform(typeText("750"),closeSoftKeyboard());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).
                perform(PickerActions.setDate(2021, 07, 04));
        onView(withId(R.id.buttonCreateVehicle)).perform(scrollTo(),click());
        onView(withText(R.string.vehicleExist)).inRoot(isDialog()).check(matches(isDisplayed()));
    }
}