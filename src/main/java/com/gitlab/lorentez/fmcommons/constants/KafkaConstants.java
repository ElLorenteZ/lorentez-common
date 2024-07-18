package com.gitlab.lorentez.fmcommons.constants;

public class KafkaConstants {

    //Topics
    public static final String KAFKA_ALARM_INCOME_TOPIC = "fm.alarm.alarm-active";
    public static final String KAFKA_ALARM_PROCESSING_TOPIC = "fm.alarm.alarm-processing";
    public static final String KAFKA_FIREBASE_NOTIFICATIONS_TOPIC = "fm.alarm.publish.firebase-notifications";
    public static final String KAFKA_WEBSOCKET_ALARM_TOPIC = "fm.alarm.publish.websocket";
    public static final String KAFKA_EMAIL_ALARM_TOPIC = "fm.alarm.publish.email";
    public static final String KAFKA_USER_AVAILABILITY = "fm.users.availability";

    //Consumer Groups
    public static final String ALARM_ACTIVE_HANDLER = "alarm.active.handler";
    public static final String ALARM_PROCESSING_HANDLER = "alarm.processing.handler";
    public static final String FIREBASE_NOTIFICATIONS_HANDLER = "alarm.publish.firebase.notifications-handler";
    public static final String WEBSOCKETS_HANDLER = "alarm.publish.websocket.handler";
    public static final String EMAIL_HANDLER = "alarm.publish.emails.handler";
    public static final String BROADCAST_USER_AVAILABILITY_HANDLER = "user.availability.handler";

    //Producer Groups
    public static final String ALARM_FORM_PRODUCER = "fm.alarm.form";
    public static final String ALARM_HANDLING_PRODUCER = "fm.alarm.handling";
    public static final String ALARM_BROADCAST_PRODUCER = "fm.alarm.broadcast";
    public static final String WEBSOCKET_PRODUCER = "fm.alarm.websocket";
}
