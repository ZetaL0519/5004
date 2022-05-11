** This is a Shape Photo Album
- Use
It takes shape infomation(shape type, name, size, color etc) from the user, and save them to the list.
The user can take snapshots whenever they want, the snapshot will record the current shape list and print it. 

- Packages and classes
This photo album is consisted of two packages, shape and model.
Shape package is constisted of IShape interface, AbstractShape abstract class, Oval, Rectangle class.
The shape package specifies what information an IShape object contains, including Type, name, Position and Color.

Model package is consisted of Model and controller. Model class and interface associates with shape package by specifing snapshot, print, change color,
change position, change size and create shape method. 

For the controller class and interface, they takes in Readable as user input and Appendable as system output. The controller
class utilizes methods in Model class, it will call different methods in Model class when the user inputs different commands.

