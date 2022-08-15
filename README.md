# bounding-box-api
REST API for operating bonding boxes

API allows you to operate bonding boxes. I think, the application is working on a photo. Bounding boxes on the photo. A bounding box is an object that has a unique id, a name, and two points (upper left corner, bottom right corner). Each point has two coordinates (x, y).

The application allows:
1) add bounding box
2) delete bounding box
3) change bounding box
4) get bounding box by id
5) get all bounding boxes

In addition, the application satisfies the following requirements:
1) the application receives and returns data in the format JSON
2) id is generated automatically

Photo size and bounding boxes size need to read from configuration file .yaml.

exemplary config:

workspace:
	image:
		width: 1920
		height: 1080
	boundingbox:
		minWidth: 10
		height: 10
