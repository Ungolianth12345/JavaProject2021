package Pharmacy;

import java.util.ArrayList;

public class TestDriver {
    public static void main(String[] args) {
        Drug m1 = new Drug("Thiosonide", "250 mg tablets", 2.49, "ColdFlu");
        Drug m2 = new Drug("Nutritriptan", "300 mg tablets", 5.49, "Digestion");
        Drug m3 = new Drug("Aeromara", "500 ml", 12.99, "Respiratory");

        ArrayList<Drug> testBatch = new ArrayList<>();
        testBatch.add(m1);
        testBatch.add(m2);
        testBatch.add(m3);

        Prescription p1 = new Prescription(10001, "Manager", testBatch);

        System.out.println(p1);
    }
}

/*
 * Here I will write some fun facts. Yes, this is unnecessary to the project but I am putting it here anyway,
 * cuz why not ¯\_(ツ)_/¯
 *
 * Warm water with salt and sugar is very useful for sick people who lost fluids due to flu or diarrhea. It is also
 * known as Oral rehydration therapy.
 *
 * Plague doctors were cool, despite the costume not working. They believed certain smells carried the bubonic plague,
 * which is half-way correct. Bad smells can indicate bacteria/disease. They put sweet-smelling things like lavender and
 * spices in the "beak" to attempt to ward off disease. This failed, tragically.
 * Most plague doctors were volunteers or young doctors learning the ropes.
 * One guy was a fruit salesman before becoming a plague doctor. They say "an apple a day keeps the doctor away". I bet
 * some of them regret not buying more fruit.
 *
 * There are thin tubes that connect the corner of your eye to your nose. This drains tears into your nose.
 * If you cry, the amount of fluid going into your nose increases, which is why your nose runs when you cry.
 *
 * After you eat a large meal, the acid produced in your stomach in effect makes your blood slightly basic. This makes
 * your oxygen bond harder to your red blood cells so less oxygen gets released into your tissues.
 * The effect: tiredness after you eat.
 * */