package assignment1;

import java.util.ArrayList;
import java.util.Random;

/*4. Create a class diagram and Java code for the following system and scenario, taking 
into account the possibility of future extensions."The system is a command line 
utility that prints a short'quote of the day'on the user's terminal when run.To begin
with thequote is selected randomly from a set of hard-coded strings within the program 
itself, but that might change later on -  the quotes might be based on the user's 
history, the time of day, the date, etc..*/

public class Four{
        public static void main(String[] args) {
                ArrayList<String> quotes = new ArrayList<>();
                // adding quotes using add function of ArrayList<>
                quotes.add("God helps them that help themselves. - Benjamin Franklin");
                quotes.add("Happiness is not a reward- it is consequence. Suffering is not a punishment- it is a result. - Robert Green");
                quotes.add("Creativity Is Intelligence Having Fun. – Albert Einstein");
                quotes.add("Future. That period of time in which our affairs prosper, our friends are true and our happiness is assured. - Ambrose Bierce");
                quotes.add("Honesty is the first chapter of the book of wisdom. - Thomas Jefferson");
                quotes.add("We May Encounter Many Defeats But We Must Not Be Defeated. – Maya Angelou");
                quotes.add("Life is what happens when you're busy making other plans. - John Lennon");
                quotes.add("It is during our darkest moments that we must focus to see the light. - Aristotle");
                quotes.add("Life is either a daring adventure or nothing at all. - Helen Keller");
                quotes.add("The Best Way To Get Started Is To Quit Talking And Begin Doing. – Walt Disney");
                quotes.add("It’s Not Whether You Get Knocked Down, It’s Whether You Get Up. – Inspirational Quote By Vince Lombardi");
                quotes.add("If you fail, never give up because Fail means “First Attempt In Learning. - A.P.J. Abdul Kalam");
                quotes.add("Whoever is happy will make others happy too. - Anne Frank");
                quotes.add("The Man Who Has Confidence In Himself Gains The Confidence Of Others. – Hasidic Proverb");
                quotes.add("A mind all logic is like a knife all blade. It makes the hand bleed that uses it. - Rabindranath Tagore.");
                quotes.add("You Are Never Too Old To Set Another Goal Or To Dream A New Dream. – C.S. Lewis");
                quotes.add("Clouds come floating into my life, no longer to carry rain or usher storm, but to add color to my sunset sky. - Rabindranath Tagore.");
                quotes.add("Love does not claim possession, but gives freedom. - Rabindranath Tagore.");
                quotes.add("Dominus Omnium Magister. It means God is the master of all things. - Satyajit Ray");
                quotes.add("One individual may die for an idea, but that idea will, after his death, incarnate itself in a thousand lives. - Netaji Subhash Chandra Bose");
                quotes.add("The Pessimist Sees Difficulty In Every Opportunity. The Optimist Sees Opportunity In Every Difficulty. – Winston Churchill");
                quotes.add("Don’t Let Yesterday Take Up Too Much Of Today. – Will Rogers");
                quotes.add("If You Are Working On Something That You Really Care About, You Don’t Have To Be Pushed. The Vision Pulls You. – Steve Jobs");
                int rand = (new Random()).nextInt(quotes.size());
                // calling nextInt(range) function of Random class to generate a random integer
                // from 0 to size of list - 1
                System.out.println(quotes.get(rand));
        }
}
