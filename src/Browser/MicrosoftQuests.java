package Browser;

import Accounts.User;
import Debug.ConsoleOut;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MicrosoftQuests {
    public static void DoDailySearches(WebDriver driver, User[] userList){

    }

    public static int[] GetDailyScore(WebDriver driver){
        driver.get("https://rewards.microsoft.com/pointsbreakdown");

        // Try to find daily search frame
        WebElement dailyScoreFrame = null;
        try{
            By searchParams = By.id("pointsCounters_pcSearchLevel1_0");
            dailyScoreFrame = driver.findElement(searchParams);
        }catch(NoSuchElementException e){
            ConsoleOut.Error("Element [" + e + "] could not be found");
        }

        try{
            By searchParams = By.id("pointsCounters_pcSearchLevel1_0");
            dailyScoreFrame = driver.findElement(searchParams);
        }catch(NoSuchElementException e){
            ConsoleOut.Error("Element [" + e + "] could not be found");
        }

        if (dailyScoreFrame == null)
            return new int[] {0, 0};

        // Try to find daily search score
        WebElement dailyScoreText = null;
        try {
            dailyScoreText = dailyScoreFrame.findElement(By.xpath("./../..")).findElement(By.className("pointsDetail"));
        } catch(NoSuchElementException e) {
            ConsoleOut.Error("Element [" + e + "] could not be found");
            return new int[] { 0, 0 };
        }

        String[] numbersInStrings = dailyScoreText.getText().split("/");
        int currentScore = Integer.parseInt(numbersInStrings[0].trim()) / 3;
        int maxScore = Integer.parseInt(numbersInStrings[1].trim()) / 3;

        return new int[] { currentScore, maxScore };
    }

    private static String[] randomWordsList = {
            "shiver",
            "friend",
            "travel",
            "weather",
            "ambitious",
            "start",
            "purple",
            "omniscient",
            "wound",
            "paper",
            "vest",
            "erect",
            "blue-eyed",
            "knotty",
            "gabby",
            "yoke",
            "suck",
            "picture",
            "condemned",
            "trot",
            "clover",
            "trust",
            "bare",
            "oven",
            "historical",
            "sock",
            "memory",
            "zoom",
            "transport",
            "chess",
            "scare",
            "crazy",
            "obeisant",
            "lush",
            "cloth",
            "flowers",
            "scintillating",
            "irritating",
            "moan",
            "smoggy",
            "ban",
            "truculent",
            "fang",
            "abstracted",
            "plot",
            "warlike",
            "wasteful",
            "versed",
            "wild",
            "old",
            "stingy",
            "faint",
            "upbeat",
            "rail",
            "belief",
            "satisfy",
            "flat",
            "discreet",
            "gainful",
            "cup",
            "girl",
            "trouble",
            "noisy",
            "quack",
            "seal",
            "force",
            "anger",
            "plate",
            "receptive",
            "phobic",
            "fence",
            "wooden",
            "faithful",
            "weary",
            "mate",
            "doubtful",
            "stain",
            "macho",
            "miniature",
            "anxious",
            "scattered",
            "hanging",
            "tease",
            "apathetic",
            "scale",
            "development",
            "rough",
            "super",
            "condition",
            "plough",
            "argument",
            "abiding",
            "fork",
            "hydrant",
            "fry",
            "magic",
            "cactus",
            "word",
            "fire",
            "pail",
            "inform",
            "sticks",
            "excited",
            "head",
            "helpful",
            "expansion",
            "mice",
            "death",
            "steady",
            "stormy"
    };
}
