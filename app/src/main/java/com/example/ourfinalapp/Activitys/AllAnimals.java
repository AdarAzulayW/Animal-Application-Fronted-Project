package com.example.ourfinalapp.Activitys;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ourfinalapp.Adapter.AnimalAdapter;
import com.example.ourfinalapp.Model.Animal;
import com.example.ourfinalapp.R;

public class AllAnimals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_animals);

        RecyclerView recyclerView;
        LinearLayoutManager layoutManager;
        AnimalAdapter englishAdapter;
        Animal[] animalList = new Animal[10];

        String animalNamesData[] = {"Frog", "Crocodile", "Lion", "Tiger", "Goat", "Horse", "Donkey", "Cheetah", "Cow", "Giraffe"};

        Integer[] animalImages = {R.drawable.frog, R.drawable.crocodile, R.drawable.lion,
                R.drawable.tiger, R.drawable.goat, R.drawable.horse, R.drawable.donkey, R.drawable.cheetah, R.drawable.cow, R.drawable.giraffe};

        String animalDescription[] = {"In general, frogs have protruding eyes, no tail, and strong, webbed hind feet that are adapted for leaping and swimming. They also possess smooth, moist skins. Many are predominantly aquatic, but some live on land, in burrows, or in trees.",
                "Crocodiles have powerful jaws with many conical teeth and short legs with clawed webbed toes. They share a unique body form that allows the eyes, ears, and nostrils to be above the water surface while most of the animal is hidden below. The tail is long and massive, and the skin is thick and plated.",
                "Lions have strong, compact bodies and powerful forelegs, teeth and jaws for pulling down and killing prey. Their coats are yellow-gold, and adult males have shaggy manes that range in color from blond to reddish-brown to black. The length and color of a lion's mane is likely determined by age, genetics and hormones.",
                "Tigers have reddish-orange coats with prominent black stripes, white bellies and white spots on their ears. Like a human fingerprint, no two tigers have the exact same markings. Because of this, researchers can use stripe patterns to identify different individuals when studying tigers in the wild.",
                "goat, any ruminant and hollow-horned mammal belonging to the genus Capra. Related to the sheep, the goat is lighter of build, has horns that arch backward, a short tail, and straighter hair. Male goats, called bucks or billys, usually have a beard.",
                "Horses have oval-shaped hooves, long tails, short hair, long slender legs, muscular and deep torso build, long thick necks, and large elongated heads. The mane is a region of coarse hairs, which extends along the dorsal side of the neck in both domestic and wild species.",
                " A donkey is a four-legged domesticated farm animal with hooves that's related to the horse. Donkeys are known for the braying sound they make and their long ears. Farmers often keep donkeys for pulling carts, carrying heavy loads, or even for guarding flocks of sheep.",
                "The cheetah's unique body structure: flexible spine, semi-retractable claws, long legs and tail allow it to achieve the unbelievable top speed of 110 km/hr (70 mph). The cheetah's body is narrow and lightweight with long slender limbs. Specialized muscles allow for a greater swing to the limbs increasing acceleration.",
                "Cows are renowned for their large milk-producing (mammary) glands known as udders, which possess four teats (nipples). Cows are well adapted for grazing (feeding on grass), with a wide mouth and specialized teeth for eating tough vegetation.",
                " The tallest land mammal, with a neck as long as 6 feet, the giraffe is also well known for the unique brown and white pattern on its coat (“pelage”) and its lengthy eyelashes and legs. Habitat: Giraffes use both semi-arid savannah and savannah woodlands in Africa."};

    }
}