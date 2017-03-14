get all events with offset&count: GET localhost:8080/eventpal-api/v1/items?offset=_OFFSET_HERE_&count=_COUNT_HERE_

get book with ID: GET http://localhost:8080/eventpal-api/v1/events/_ID_HERE_

add new book: PUT http://localhost:8080/api/eventpal-v1/items/ see EX1

delete book with ID: DELETE http://localhost:8080/eventpal-api/v1/events/_ID_HERE_

delete all books: DELETE http://localhost:8080/eventpal-api/v1/events/


EX1: example of http body (json object):
{
	"name":"EventName",
	"title":"EventDescription",
	"author":"Sherafgan",
	"latitude":3123.12312,
	"longitude":123.1212
}
