package framgia.vn.framgiacrb.data.model;

import android.content.Context;

import java.util.Date;

import io.realm.RealmResults;

/**
 * Created by nghicv on 20/07/2016.
 */
public interface EventRepository {
    void insertEvent(Event event);
    void deleteEvent(Event event);
    void updateEvent(Event event);
    RealmResults<Event> getAllEvents(int userId);
    void getEventsByCalendar(String token, Calendar calendar, Context context);
    Event getEventById(int id);
    RealmResults<Event> getEventByDate(Date date);
}
