PhotoAlbum Project
### This project encompasses the model, shape, view and controller packages for the PhotoAlbum project.
The previous homework only works on the model and shape part, with textual view of controller.

### Packages and classes
## Model Package:
# IShapeModel.java
It represents the interface class of Shape model method.

# ShapeModel.java
It represents the class of Shape model method. It implements methods of moving, creating, resizing, coloring the shape.

# SnapShot.java
It represents the class of Snapshot. A Snapshot consists of ShapeList, SnapID and description information.

## Shape package:
# IShape.java
It represents the interface of an IShape object.

# AbstractShape.java
It represents the abstract class of an IShape object.

# Oval.java
It represents the class of Oval object.

# Rectangle.java
It represents the class of Rectangle object.

# Color.java
It represents the class of Color, which consists of information of RGB value.

# Position.java
It represents the class of Position, which consists of information of coordinates.

## Controller package:
# AnimationBuilder.java
It represents the interface class of builder which encapsulates model.

# AnimationBuilderImp.java
It represents the class of builder implementing the builder interface.

# IAnimationController.java
It represents the interface of controller.

# AnimationWebController.java
It represents controller connecting Web view and shape model.

# AnimationGraphicController.java
It represents controller connecting Graphic view and shape model.

# AnimationReader.java
It represents the class reading input file and parsing file.

## View package:
# DrawingPanel.java
It represents drawing panel class painting the main snapshot.

# IView.java
It represents the interface class of View.

# GraphicView.java
It represents the graphic view class.

# WebView.java
It represents the web view class.