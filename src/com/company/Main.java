package com.company;

import java.util.*;

public class Main {

    public static class Pair{
        public String competitor;
        public int mentions;

        Pair(String competitor, int mentions){
            this.competitor = competitor;
            this.mentions = mentions;
        }
    }

    public static void main(String[] args) {
	    List<String> competitorList = new ArrayList<>();
	    competitorList.add("Ebay");
	    competitorList.add("Etsy");
	    competitorList.add("Wish");
	    competitorList.add("Mercari");
	    competitorList.add("Target");
	    competitorList.add("Walmart");
	    competitorList.add("HEB");
	    competitorList.add("Kmart");
	    List<String> reviewList = new ArrayList<>();
	    String[] reviews = {
	            "Ebay provides the best Service",
                "Best Services Provided by Ebay",
                "My favorite is Etsy",
                "Wish gets me my favorite on time",
                "Mercari Is great",
                "Wish is cheap but great",
                "Wish the best for cheap",
                "Wish sometimes better than Amazon",
                "Target, Helps me get what I want",
                "I get my groceries from HEB",
                "Kmart helps me succeed",
                "Walmart, i guessd"
        };
	    for(String s: reviews){
	        reviewList.add(s);
        }

	    ArrayList<String> result = topNCompetitors(competitorList.size(), 5, reviewList.size(), reviewList, competitorList);
	    printStringArrayList(result);
    }

    public static void printStringArrayList(ArrayList<String> stringArrayList){
        StringBuilder resultBuilder = new StringBuilder("[ ");
        for(String s: stringArrayList){
            resultBuilder.append(s+ ", ");
        }
        resultBuilder.replace(resultBuilder.length()-2, resultBuilder.length(), " ]");
        System.out.println(resultBuilder.toString());
    }

    public static ArrayList<String> sortByValue(HashMap<String, Integer> hm)
    {
        List<Map.Entry<String, Integer> > list = new LinkedList<>(hm.entrySet());
        Comparator comparator = new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        };

        Collections.sort(list, comparator);
        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        ArrayList<String> output = new ArrayList<>();
        for (Map.Entry<String, Integer> en : temp.entrySet()) {
            output.add(en.getKey());
        }
        return output;
    }

    public static ArrayList<String> topNCompetitors(int numOfComp, int topN, int numReviews, List<String> reviews, List<String> competitors){
        HashMap<String, Integer> compCount = new HashMap<>();

        //Itterate through Competitors work O(Competitors)
        for(String s: competitors){
            compCount.put(s, 0);
        }

        //Linear Search reviews only ONCE for competitor name work done in O(Reviews)
        for(String review: reviews){
            //Format string by removing punctuation or unwanted characters
            review = review.replaceAll("[.!?,'\\-]","");
            String[] words = review.split(" ");
            for(String word: words){
                if(compCount.containsKey(word)){
                    String competitor = word;
                    compCount.put(competitor, compCount.get(competitor) + 1);
                }
            }
        }

        //Return reverse sorted ArrayList. Where N is the top N competitors desired, time complexity is O(nLog(n))
        return sortByValue(compCount);

        //Final Runtime O(Competitors + Reviews + nLog(n)) -> O(C+R+nLog(n))
    }
}
