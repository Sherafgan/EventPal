### Status
[![Build Status](https://travis-ci.com/Sherafgan/eventpal-RESTful.svg?token=TtzuqDhEG7q2DHFCzAq5&branch=master)](https://travis-ci.com/Sherafgan/eventpal-RESTful)

get all events with offset&count: GET http://sherafgan.me/eventpal-api/v1/events?offset=_OFFSET_HERE_&count=_COUNT_HERE_

get event with ID: GET http://sherafgan.me/eventpal-api/v1/events/_ID_HERE_

add new event: PUT http://sherafgan.me/eventpal-api/v1/events/ with json body as in EX1

delete event with ID: DELETE http://sherafgan.me/eventpal-api/v1/events/_ID_HERE_

delete all events: DELETE http://sherafgan.me/eventpal-api/v1/events/


EX1: example of http body (json object):
```json
{
	"name":"EventName",
	"title":"EventDescription",
	"author":"Sherafgan",
	"latitude":3123.12312,
	"longitude":123.1212
}
```
