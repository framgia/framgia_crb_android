package framgia.vn.framgiacrb.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import framgia.vn.framgiacrb.constant.Constant;
import framgia.vn.framgiacrb.utils.GoogleCalendarUtil;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Event extends RealmObject {
    @PrimaryKey
    @SerializedName("id")
    private int mId;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("start_date")
    private Date mStartTime;
    @SerializedName("finish_date")
    private Date mFinishTime;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("repeat_type")
    private String mRepeatType;
    @SerializedName("repeat_every")
    private int mRepeatEvery;
    @SerializedName("exception_date")
    private Date mExceptionDate;
    @SerializedName("type")
    private int mType;
    @SerializedName("event_id")
    private int mEventId;
    @SerializedName("color")
    private String mColorId;
    @SerializedName("attendees")
    private RealmList<Attendee> mAttendees;
    @SerializedName("place")
    private Place mPlace;
    @SerializedName("calendar_id")
    private int mCalendarId;
    @SerializedName("all_day")
    private boolean mAllDay;
    @SerializedName("start_repeat")
    private Date mStartRepeat;
    @SerializedName("end_repeat")
    private Date mEndRepeat;
    @SerializedName("user_id")
    private int mUserId;
    @SerializedName("days_of_weeks")
    private RealmList<DayOfWeek> mDayOfWeeks;
    @SerializedName("parent_id")
    private String mParentId;
    @SerializedName("exception_type")
    private String mExceptionType;
    @SerializedName("exception_time")
    private Date mExceptionTime;

    public String getGoogleCalendarName() {
        return mGoogleCalendarName;
    }

    public void setGoogleCalendarName(String googleCalendarName) {
        mGoogleCalendarName = googleCalendarName;
    }

    private String mGoogleCalendarName;

    public boolean isGoogleEvent() {
        return mIsGoogleEvent;
    }

    public void setGoogleEvent(boolean googleEvent) {
        mIsGoogleEvent = googleEvent;
    }

    private boolean mIsGoogleEvent;

    public Event() {
    }

    public Event(Event event) {
        mId = event.getId();
        mIsGoogleEvent = event.isGoogleEvent();
        mTitle = event.getTitle();
        mDescription = event.getDescription();
        mStartTime = event.getStartTime();
        mFinishTime = event.getFinishTime();
        mStatus = event.getStatus();
        mRepeatType = event.getRepeatType();
        mRepeatEvery = event.getRepeatEvery();
        mExceptionDate = event.getExceptionDate();
        mType = event.getType();
        mEventId = event.getEventId();
        mColorId = event.getColorId();
        mPlace = event.getPlace() == null ? null : new Place(event.getPlace());
        mAttendees =
            event.getAttendees() == null ? null : Attendee.cloneListAttendee(event.getAttendees());
        mCalendarId = event.getCalendarId();
        mAllDay = event.isAllDay();
        mUserId = event.getUserId();
        mStartRepeat = event.getStartRepeat();
        mEndRepeat = event.getEndRepeat();
        mDayOfWeeks = event.getDayOfWeeks() == null ? null :
            DayOfWeek.cloneListDayOfWeek(event.getDayOfWeeks());
    }

    public Event(GoogleEvent googleEvent) {
        mId = googleEvent.getId();
        mIsGoogleEvent = true;
        mTitle = googleEvent.getTitle();
        mDescription = googleEvent.getDescription();
        mStartTime = googleEvent.getStartTime();
        mFinishTime = googleEvent.getFinishTime();
        mColorId = googleEvent.getColor();
        mStartRepeat = mStartTime;
        mEndRepeat = GoogleCalendarUtil.getEndRepeat(googleEvent.getRule());
        mAllDay = googleEvent.getIsAllDay().equals(Constant.GoogleCalendar.IS_ALL_DAY_TRUE);
        mGoogleCalendarName = googleEvent.getCalendarName();
        mRepeatType = GoogleCalendarUtil.getRepeatType(googleEvent.getRule());
        mRepeatEvery = GoogleCalendarUtil.getRepeatEvery(googleEvent.getRule());
        mDayOfWeeks = GoogleCalendarUtil.getListDayOfWeek(googleEvent.getRule());
    }

    public RealmList<DayOfWeek> getDayOfWeeks() {
        return mDayOfWeeks;
    }

    public void setDayOfWeeks(
        RealmList<DayOfWeek> dayOfWeeks) {
        mDayOfWeeks = dayOfWeeks;
    }

    public String getColorId() {
        return mColorId;
    }

    public void setColorId(String colorId) {
        mColorId = colorId;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Date getStartTime() {
        return mStartTime;
    }

    public void setStartTime(Date startTime) {
        mStartTime = startTime;
    }

    public Date getFinishTime() {
        return mFinishTime;
    }

    public void setFinishTime(Date finishTime) {
        mFinishTime = finishTime;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        this.mStatus = status;
    }

    public String getRepeatType() {
        return mRepeatType;
    }

    public void setRepeatType(String repeatType) {
        mRepeatType = repeatType;
    }

    public int getRepeatEvery() {
        return mRepeatEvery;
    }

    public void setRepeatEvery(int repeatEvery) {
        mRepeatEvery = repeatEvery;
    }

    public Date getExceptionDate() {
        return mExceptionDate;
    }

    public void setExceptionDate(Date exceptionDate) {
        mExceptionDate = exceptionDate;
    }

    public int getType() {
        return mType;
    }

    public void setType(int type) {
        mType = type;
    }

    public int getEventId() {
        return mEventId;
    }

    public void setEventId(int eventId) {
        mEventId = eventId;
    }

    public boolean isAllDay() {
        return mAllDay;
    }

    public void setAllDay(boolean allDay) {
        this.mAllDay = allDay;
    }

    public int getUserId() {
        return mUserId;
    }

    public int getCalendarId() {
        return mCalendarId;
    }

    public void setCalendarId(int calendarId) {
        mCalendarId = calendarId;
    }

    public RealmList<Attendee> getAttendees() {
        return mAttendees;
    }

    public Place getPlace() {
        return mPlace;
    }

    public Date getStartRepeat() {
        return mStartRepeat;
    }

    public void setStartRepeat(Date mStartRepeat) {
        this.mStartRepeat = mStartRepeat;
    }

    public Date getEndRepeat() {
        return mEndRepeat;
    }

    public void setEndRepeat(Date mEndRepeat) {
        this.mEndRepeat = mEndRepeat;
    }

    public String getParentId() {
        return mParentId;
    }

    public void setParentId(String parentId) {
        mParentId = parentId;
    }

    public String getExceptionType() {
        return mExceptionType;
    }

    public void setExceptionType(String exceptionType) {
        mExceptionType = exceptionType;
    }

    public Date getExceptionTime() {
        return mExceptionTime;
    }

    public void setExceptionTime(Date exceptionTime) {
        mExceptionTime = exceptionTime;
    }
}