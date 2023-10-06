package com.example.ourfinalapp.Activitys;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ourfinalapp.Adapter.AnimalAdapter;
import com.example.ourfinalapp.Model.Animal;
import com.example.ourfinalapp.R;
public class HomePage extends AppCompatActivity {



    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    AnimalAdapter englishAdapter;
    AnimalAdapter heblishAdapter;
    Animal[] animalListEng = new Animal[10];
    Animal[] animalListHeb = new Animal[10];

    Button ChangeLang ;
    Button ShareData ;
    Boolean Flag = true;
    // true -> english
    //false -> hebrew
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        String animalNamesData[] = {"Frog", "Crocodile", "Lion", "Tiger", "Goat", "Horse", "Donkey", "Cheetah", "Cow", "Giraffe"};
        String animalNamesDataHeb[] = {"צפרדע", "תנין", "אריה", "נמר", "עז", "סוס", "חמור", "צי׳טה", "פרה", "ג׳ירפה"};

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
        String animalDescriptionHeb[] = {"באופן כללי, לצפרדעים יש עיניים בולטות, ללא זנב, וכפות רגליים אחוריות חזקות וקורות, המותאמות לזינוק ולשחייה. יש להן גם עור חלק ולח. רבות מהן הן בעיקר מימיות, אבל חלקן חיות ביבשה, במחילות או בתוך עצים.",
                "לתנינים יש לסתות חזקות עם שיניים חרוטיות רבות ורגליים קצרות עם אצבעות ציפורניים. הם חולקים צורת גוף ייחודית המאפשרת לעיניים, לאוזניים ולנחיריים להיות מעל פני המים בעוד שרוב החיה מוסתרת מתחת. הזנב הוא ארוך ומסיבי, והעור עבה ומצופה.",
                "לאריות יש גוף חזק וקומפקטי ורגליים קדמיות חזקות, שיניים ולסתות למשיכה מטה והרג טרף. המעיל שלהם צהוב-זהוב, ולזכרים בוגרים יש רעמות מדובללות שצבען נע בין בלונדיני לחום אדמדם לשחור. צבע רעמת אריה ככל הנראה נקבע על פי גיל, גנטיקה והורמונים",
                "לנמרים יש מעילים אדמדמים-כתומים עם פסים שחורים בולטים, בטן לבנה וכתמים לבנים על האוזניים. כמו טביעת אצבע אנושית, אין לשני נמרים אותם סימנים בדיוק. בגלל זה, חוקרים יכולים להשתמש בדפוסי פסים כדי לזהות פרטים שונים בעת מחקר נמרים בטבע.",
                "עז, כל יונק מעלה גירה וחלול קרן השייך לסוג קפרה. קשור לכבשים, העז קלה יותר במבנה שלה, יש לה קרניים שמקשתות לאחור, זנב קצר ושיער חלק יותר. עיזים זכרים, הנקראות בוקס או בילי, בדרך כלל יש זקן",
                "לסוסים יש פרסות בצורת אליפסה, זנבות ארוכים, שיער קצר, רגליים דקות ארוכות, מבנה פלג גוף עליון שרירי ועמוק, צוואר ארוך עבה וראשים גדולים ומוארכים. הרעמה היא אזור של שערות גסות, המשתרע לאורך הצד הגבי של צוואר במינים ביתיים ובראים כאחד.",
                "חמור הוא חיית משק מבויתת בעלת ארבע רגליים עם פרסות שקשורות לסוס. חמורים ידועים בקול התרועה שהם משמיעים ובאוזניהם הארוכות. חקלאים לרוב מחזיקים חמורים למשיכת עגלות, לשאת משאות כבדים, או אפילו לשמירה על עדרים. של כבשים",
                "מבנה הגוף הייחודי של הצ'יטה: עמוד שדרה גמיש, טפרים נשלפים למחצה, רגליים ארוכות וזנב מאפשרים לו להגיע למהירות המרבית המדהימה של 110 קמש (70 קמש). גוף הצ'יטה צר וקל משקל עם גפיים דקות ארוכות. מתמחה השרירים מאפשרים תנופה גדולה יותר לגפיים ומגדילים את התאוצה",
                "פרות ידועות בבלוטות החלב הגדולות שלהן הידועות בשם עטינים, בעלות ארבע פטמות (פטמות). פרות מותאמות היטב למרעה (האכלה מדשא), בעלות פה רחב ושיניים מיוחדות לאכילת צמחייה קשה",
                " היונק היבשתי הגבוה ביותר, עם צוואר שאורכו עד 6 מטרים, הג'ירפה ידועה גם בזכות הדפוס החום והלבן הייחודי על הפרווה שלה (פלאג') והריסים והרגליים הארוכים שלה. בית גידול: ג'ירפות משתמשות בשני החצי- סוואנה צחיחה וחורשות סוואנה באפריקה."};

        ChangeLang = findViewById(R.id.changeLang);
        ShareData = findViewById(R.id.sharedata);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);

        for ( int i= 0; i < animalListEng.length; i++) {
            animalListEng[i] = new Animal(animalImages[i], animalNamesData[i],animalDescription[i] );

        }

        for ( int i =0; i< animalListHeb.length; i++){
            animalListHeb[i] = new Animal(animalImages[i], animalNamesDataHeb[i],animalDescriptionHeb[i] );
        }

        //connecting the Eng adapter
        englishAdapter = new AnimalAdapter(animalListEng);
        heblishAdapter = new AnimalAdapter(animalListHeb);


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(englishAdapter);


        ChangeLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Flag = !Flag;

                if (Flag == true ) {
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(englishAdapter);
                    ChangeLang.setText("\uD83C\uDDFA\uD83C\uDDF8");
                }
                else {
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(heblishAdapter);
                    ChangeLang.setText("\uD83C\uDDEE\uD83C\uDDF1");
                }
            }
        });

        ShareData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Flag == true) { //english
                    shareData(animalDescription);
                }
                else { // hebrew
                    shareData(animalDescriptionHeb);
                }

            }
        });
    }
    public void shareData(String[] Animalslist)
    {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        String text ="";
        i.putExtra(Intent.EXTRA_SUBJECT, "Share Animal Data!");  ///to add a subject with the share point
        for(String desc : Animalslist){
           text += desc;
           text += "\n\n";
        }
        i.putExtra(Intent.EXTRA_TEXT,text);
        startActivity(Intent.createChooser(i, "choose a platform"));
    }
}