package DesignPatterns.BehavioralPatterns.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

interface NewsObserver {
    void update(String news);
}

interface NewsPublication {
    void attach(NewsObserver obs);

    void detach(NewsObserver obs);

    void notifyObservers();
}

class Publication implements NewsPublication {
    private String News;
    private List<NewsObserver> SubscribersList;

    public Publication() {
        this.SubscribersList = new ArrayList<>();
    }

    @Override
    public void attach(NewsObserver obs) {
        SubscribersList.add(obs);
    }

    @Override
    public void detach(NewsObserver obs) {
        SubscribersList.remove(obs);
    }

    public void setNews(String news) {
        this.News = news;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (NewsObserver obs : SubscribersList) {
            obs.update(News);
        }
    }

}

class SubscriberOne implements NewsObserver {
    @Override
    public void update(String news) {
        System.out.println("Subscriber one is for news  " + news);
    }
}

class SubscriberTwo implements NewsObserver {
    @Override
    public void update(String news) {
        System.out.println("subscriber two is for news " + news);
    }
}

public class NewsArticleExampleTwo {
    public static void main(String[] args) {

//        initiating publishing house
        Publication publication = new Publication();

//        initiating subscribers
        SubscriberOne subscriberOne = new SubscriberOne();
        SubscriberTwo subscriberTwo = new SubscriberTwo();


//        attaching subscribers
        publication.attach(subscriberOne);
        publication.attach(subscriberTwo);

//adding article
        publication.setNews("news by john for pune location.");
        publication.detach(subscriberOne);
        System.out.println("--------------------------");
//notified to only one subscriber
        publication.setNews("news by john for mumbai location.");
    }

}
