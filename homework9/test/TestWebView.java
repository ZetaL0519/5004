import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import Controller.AnimationBuilderImp;
import Model.IShapeModel;
import View.WebView;
import static org.junit.Assert.assertEquals;

/**
 * This is the WebView test class.
 */
public class TestWebView {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private IShapeModel model;
  private AnimationBuilderImp animationBuilder;

  /**
   * Set up builder object.
   */
  @Before
  public void SetUp() {
    animationBuilder = new AnimationBuilderImp();
    System.setOut(new PrintStream(outContent));
  }

  /**
   * Test the top and end appending.
   */
  @Test
  public void TestHTMLAppend() {
    this.model = this.animationBuilder.build();
    WebView view = new WebView(model, 1000, 1000);
    assertEquals(view.getOutput(), "");
    view.display();
    assertEquals(view.getOutput(), "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<body>\n" + "</body>\n" +
            "</html>");
  }

  /**
   * Test simple create shape method.
   */
  @Test
  public void TestXMLAppendShapes() {
    this.animationBuilder.createShape("First", "Oval", 10, 10, 30, 30, 0, 255, 0);
    this.animationBuilder.createShape("Second", "Rectangle", 20, 20, 50, 60, 255, 98, 0);
    this.animationBuilder.SnapShot("first Snap");
    this.model = this.animationBuilder.build();
    String SnapID = this.model.getSnapshotList().get(0).getSnapShotID();
    WebView view = new WebView(this.model, 1000, 1000);
    view.display();
    assertEquals(view.getOutput(), "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<body>\n" +
            "<svg width=\"1000\" height=\"1000\" version=\"1.1\"style =\"border: solid 2px red; background-color:rgb(173,216,230)\"\n" +
            "xmlns=\"http://www.w3.org/2000/svg\">\n" +
            "<g><ellipse id=\"First\" cx=\"10.00\" cy=\"210.00\" rx=\"15.00\" ry=\"15.00\" fill=\"rgb(0.000000,255.000000,0.000000)\" visibility=\"visible\"/> \n" +
            "<rect id=\"Second\" x=\"20.00\" y=\"220.00\" width=\"50.00\" height=\"60.00\" fill=\"rgb(255.000000,98.000000,0.000000)\" visibility=\"visible\" /> \n" +
            "<text x=\"10\" y=\"40\" font-weight=\"bold\" font-size=\"30\">" + SnapID + "</text>\n" +
            "<text x=\"10\" y=\"70\" font-size=\"20\">Description: first Snap</text>\n" +
            "</g></svg>\n" +
            "<p></p>\n" +
            "</body>\n" +
            "</html>");
  }

  /**
   * Test null model.
   */
  @Test(expected = NullPointerException.class)
  public void TestNullModel() {
    WebView view = new WebView(this.model, 1000, 1000);
    view.display();
  }

  /**
   * Test multiple snapshot.
   */
  @Test
  public void TestMultipleSnapshot() {
    this.animationBuilder.createShape("First", "Oval", 10, 10, 30, 30, 0, 255, 0);
    this.animationBuilder.SnapShot("first Snap");
    this.animationBuilder.createShape("Second", "Rectangle", 20, 20, 50, 60, 255, 98, 0);
    this.animationBuilder.SnapShot("Second Snap");
    this.animationBuilder.createShape("Third", "Oval", 100, 90, 45, 60, 45, 67, 150);
    this.animationBuilder.SnapShot("Third Snap");
    this.model = this.animationBuilder.build();
    String SnapID1 = this.model.getSnapshotList().get(0).getSnapShotID();
    String SnapID2 = this.model.getSnapshotList().get(1).getSnapShotID();
    String SnapID3 = this.model.getSnapshotList().get(2).getSnapShotID();
    WebView view = new WebView(this.model, 1000, 1000);
    view.display();
    assertEquals(view.getOutput(), "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<body>\n" +
            "<svg width=\"1000\" height=\"1000\" version=\"1.1\"style =\"border: solid 2px red; background-color:rgb(173,216,230)\"\n" +
            "xmlns=\"http://www.w3.org/2000/svg\">\n" +
            "<g><ellipse id=\"First\" cx=\"10.00\" cy=\"210.00\" rx=\"15.00\" ry=\"15.00\" fill=\"rgb(0.000000,255.000000,0.000000)\" visibility=\"visible\"/> \n" +
            "<text x=\"10\" y=\"40\" font-weight=\"bold\" font-size=\"30\">" + SnapID1 + "</text>\n" +
            "<text x=\"10\" y=\"70\" font-size=\"20\">Description: first Snap</text>\n" +
            "</g></svg>\n" +
            "<p></p>\n" +
            "<svg width=\"1000\" height=\"1000\" version=\"1.1\"style =\"border: solid 2px red; background-color:rgb(173,216,230)\"\n" +
            "xmlns=\"http://www.w3.org/2000/svg\">\n" +
            "<g><ellipse id=\"First\" cx=\"10.00\" cy=\"210.00\" rx=\"15.00\" ry=\"15.00\" fill=\"rgb(0.000000,255.000000,0.000000)\" visibility=\"visible\"/> \n" +
            "<rect id=\"Second\" x=\"20.00\" y=\"220.00\" width=\"50.00\" height=\"60.00\" fill=\"rgb(255.000000,98.000000,0.000000)\" visibility=\"visible\" /> \n" +
            "<text x=\"10\" y=\"40\" font-weight=\"bold\" font-size=\"30\">" + SnapID2 + "</text>\n" +
            "<text x=\"10\" y=\"70\" font-size=\"20\">Description: Second Snap</text>\n" +
            "</g></svg>\n" +
            "<p></p>\n" +
            "<svg width=\"1000\" height=\"1000\" version=\"1.1\"style =\"border: solid 2px red; background-color:rgb(173,216,230)\"\n" +
            "xmlns=\"http://www.w3.org/2000/svg\">\n" +
            "<g><ellipse id=\"First\" cx=\"10.00\" cy=\"210.00\" rx=\"15.00\" ry=\"15.00\" fill=\"rgb(0.000000,255.000000,0.000000)\" visibility=\"visible\"/> \n" +
            "<rect id=\"Second\" x=\"20.00\" y=\"220.00\" width=\"50.00\" height=\"60.00\" fill=\"rgb(255.000000,98.000000,0.000000)\" visibility=\"visible\" /> \n" +
            "<ellipse id=\"Third\" cx=\"100.00\" cy=\"290.00\" rx=\"22.50\" ry=\"30.00\" fill=\"rgb(45.000000,67.000000,150.000000)\" visibility=\"visible\"/> \n" +
            "<text x=\"10\" y=\"40\" font-weight=\"bold\" font-size=\"30\">" + SnapID3 + "</text>\n" +
            "<text x=\"10\" y=\"70\" font-size=\"20\">Description: Third Snap</text>\n" +
            "</g></svg>\n" +
            "<p></p>\n" +
            "</body>\n" +
            "</html>");
  }

  /**
   * Test Move shape method.
   */
  @Test
  public void TestMoveShape() {
    this.animationBuilder.createShape("First", "Oval", 10, 10, 30, 30, 0, 255, 0);
    this.animationBuilder.MoveShape("First", 20, 20);
    this.animationBuilder.SnapShot("first Snap");
    this.animationBuilder.createShape("Second", "Rectangle", 20, 20, 50, 60, 255, 98, 0);
    this.animationBuilder.MoveShape("Second", 30, 30);
    this.animationBuilder.SnapShot("Second Snap");
    this.animationBuilder.createShape("Third", "Oval", 100, 90, 45, 60, 45, 67, 150);
    this.animationBuilder.SnapShot("Third Snap");
    this.model = this.animationBuilder.build();
    String SnapID1 = this.model.getSnapshotList().get(0).getSnapShotID();
    String SnapID2 = this.model.getSnapshotList().get(1).getSnapShotID();
    String SnapID3 = this.model.getSnapshotList().get(2).getSnapShotID();
    WebView view = new WebView(this.model, 1000, 1000);
    view.display();
    assertEquals(view.getOutput(),"<!DOCTYPE html>\n" +
            "<html>\n" +
            "<body>\n" +
            "<svg width=\"1000\" height=\"1000\" version=\"1.1\"style =\"border: solid 2px red; background-color:rgb(173,216,230)\"\n" +
            "xmlns=\"http://www.w3.org/2000/svg\">\n" +
            "<g><ellipse id=\"First\" cx=\"20.00\" cy=\"220.00\" rx=\"15.00\" ry=\"15.00\" fill=\"rgb(0.000000,255.000000,0.000000)\" visibility=\"visible\"/> \n" +
            "<text x=\"10\" y=\"40\" font-weight=\"bold\" font-size=\"30\">" + SnapID1 + "</text>\n" +
            "<text x=\"10\" y=\"70\" font-size=\"20\">Description: first Snap</text>\n" +
            "</g></svg>\n" +
            "<p></p>\n" +
            "<svg width=\"1000\" height=\"1000\" version=\"1.1\"style =\"border: solid 2px red; background-color:rgb(173,216,230)\"\n" +
            "xmlns=\"http://www.w3.org/2000/svg\">\n" +
            "<g><ellipse id=\"First\" cx=\"20.00\" cy=\"220.00\" rx=\"15.00\" ry=\"15.00\" fill=\"rgb(0.000000,255.000000,0.000000)\" visibility=\"visible\"/> \n" +
            "<rect id=\"Second\" x=\"30.00\" y=\"230.00\" width=\"50.00\" height=\"60.00\" fill=\"rgb(255.000000,98.000000,0.000000)\" visibility=\"visible\" /> \n" +
            "<text x=\"10\" y=\"40\" font-weight=\"bold\" font-size=\"30\">" + SnapID2 + "</text>\n" +
            "<text x=\"10\" y=\"70\" font-size=\"20\">Description: Second Snap</text>\n" +
            "</g></svg>\n" +
            "<p></p>\n" +
            "<svg width=\"1000\" height=\"1000\" version=\"1.1\"style =\"border: solid 2px red; background-color:rgb(173,216,230)\"\n" +
            "xmlns=\"http://www.w3.org/2000/svg\">\n" +
            "<g><ellipse id=\"First\" cx=\"20.00\" cy=\"220.00\" rx=\"15.00\" ry=\"15.00\" fill=\"rgb(0.000000,255.000000,0.000000)\" visibility=\"visible\"/> \n" +
            "<rect id=\"Second\" x=\"30.00\" y=\"230.00\" width=\"50.00\" height=\"60.00\" fill=\"rgb(255.000000,98.000000,0.000000)\" visibility=\"visible\" /> \n" +
            "<ellipse id=\"Third\" cx=\"100.00\" cy=\"290.00\" rx=\"22.50\" ry=\"30.00\" fill=\"rgb(45.000000,67.000000,150.000000)\" visibility=\"visible\"/> \n" +
            "<text x=\"10\" y=\"40\" font-weight=\"bold\" font-size=\"30\">" + SnapID3 + "</text>\n" +
            "<text x=\"10\" y=\"70\" font-size=\"20\">Description: Third Snap</text>\n" +
            "</g></svg>\n" +
            "<p></p>\n" +
            "</body>\n" +
            "</html>");
  }

  /**
   * Test Remove shape method.
   */
  @Test
  public void TestRemoveShape() {
    this.animationBuilder.createShape("First", "Oval", 10, 10, 30, 30, 0, 255, 0);
    this.animationBuilder.MoveShape("First", 20, 20);
    this.animationBuilder.SnapShot("first Snap");
    this.animationBuilder.createShape("Second", "Rectangle", 20, 20, 50, 60, 255, 98, 0);
    this.animationBuilder.MoveShape("Second", 30, 30);
    this.animationBuilder.SnapShot("Second Snap");
    this.animationBuilder.createShape("Third", "Oval", 100, 90, 45, 60, 45, 67, 150);
    this.animationBuilder.RemoveShape("Second");
    this.animationBuilder.SnapShot("Third Snap");
    this.model = this.animationBuilder.build();
    String SnapID1 = this.model.getSnapshotList().get(0).getSnapShotID();
    String SnapID2 = this.model.getSnapshotList().get(1).getSnapShotID();
    String SnapID3 = this.model.getSnapshotList().get(2).getSnapShotID();
    WebView view = new WebView(this.model, 1000, 1000);
    view.display();
    assertEquals(view.getOutput(), "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<body>\n" +
            "<svg width=\"1000\" height=\"1000\" version=\"1.1\"style =\"border: solid 2px red; background-color:rgb(173,216,230)\"\n" +
            "xmlns=\"http://www.w3.org/2000/svg\">\n" +
            "<g><ellipse id=\"First\" cx=\"20.00\" cy=\"220.00\" rx=\"15.00\" ry=\"15.00\" fill=\"rgb(0.000000,255.000000,0.000000)\" visibility=\"visible\"/> \n" +
            "<text x=\"10\" y=\"40\" font-weight=\"bold\" font-size=\"30\">" + SnapID1 + "</text>\n" +
            "<text x=\"10\" y=\"70\" font-size=\"20\">Description: first Snap</text>\n" +
            "</g></svg>\n" +
            "<p></p>\n" +
            "<svg width=\"1000\" height=\"1000\" version=\"1.1\"style =\"border: solid 2px red; background-color:rgb(173,216,230)\"\n" +
            "xmlns=\"http://www.w3.org/2000/svg\">\n" +
            "<g><ellipse id=\"First\" cx=\"20.00\" cy=\"220.00\" rx=\"15.00\" ry=\"15.00\" fill=\"rgb(0.000000,255.000000,0.000000)\" visibility=\"visible\"/> \n" +
            "<rect id=\"Second\" x=\"30.00\" y=\"230.00\" width=\"50.00\" height=\"60.00\" fill=\"rgb(255.000000,98.000000,0.000000)\" visibility=\"visible\" /> \n" +
            "<text x=\"10\" y=\"40\" font-weight=\"bold\" font-size=\"30\">" + SnapID2 + "</text>\n" +
            "<text x=\"10\" y=\"70\" font-size=\"20\">Description: Second Snap</text>\n" +
            "</g></svg>\n" +
            "<p></p>\n" +
            "<svg width=\"1000\" height=\"1000\" version=\"1.1\"style =\"border: solid 2px red; background-color:rgb(173,216,230)\"\n" +
            "xmlns=\"http://www.w3.org/2000/svg\">\n" +
            "<g><ellipse id=\"First\" cx=\"20.00\" cy=\"220.00\" rx=\"15.00\" ry=\"15.00\" fill=\"rgb(0.000000,255.000000,0.000000)\" visibility=\"visible\"/> \n" +
            "<ellipse id=\"Third\" cx=\"100.00\" cy=\"290.00\" rx=\"22.50\" ry=\"30.00\" fill=\"rgb(45.000000,67.000000,150.000000)\" visibility=\"visible\"/> \n" +
            "<text x=\"10\" y=\"40\" font-weight=\"bold\" font-size=\"30\">" + SnapID3 + "</text>\n" +
            "<text x=\"10\" y=\"70\" font-size=\"20\">Description: Third Snap</text>\n" +
            "</g></svg>\n" +
            "<p></p>\n" +
            "</body>\n" +
            "</html>");
  }

  /**
   * Test change shape color method.
   */
  @Test
  public void TestColorShape() {
    this.animationBuilder.createShape("First", "Oval", 10, 10, 30, 30, 0, 255, 0);
    this.animationBuilder.MoveShape("First", 20, 20);
    this.animationBuilder.ColorShape("First", 200, 65, 43);
    this.animationBuilder.SnapShot("first Snap");
    this.animationBuilder.createShape("Second", "Rectangle", 20, 20, 50, 60, 255, 98, 0);
    this.animationBuilder.MoveShape("Second", 30, 30);
    this.animationBuilder.SnapShot("Second Snap");
    this.animationBuilder.createShape("Third", "Oval", 100, 90, 45, 60, 45, 67, 150);
    this.animationBuilder.ColorShape("Third", 34, 56, 90);
    this.animationBuilder.SnapShot("Third Snap");
    this.model = this.animationBuilder.build();
    String SnapID1 = this.model.getSnapshotList().get(0).getSnapShotID();
    String SnapID2 = this.model.getSnapshotList().get(1).getSnapShotID();
    String SnapID3 = this.model.getSnapshotList().get(2).getSnapShotID();
    WebView view = new WebView(this.model, 1000, 1000);
    view.display();
    assertEquals(view.getOutput(),"<!DOCTYPE html>\n" +
            "<html>\n" +
            "<body>\n" +
            "<svg width=\"1000\" height=\"1000\" version=\"1.1\"style =\"border: solid 2px red; background-color:rgb(173,216,230)\"\n" +
            "xmlns=\"http://www.w3.org/2000/svg\">\n" +
            "<g><ellipse id=\"First\" cx=\"20.00\" cy=\"220.00\" rx=\"15.00\" ry=\"15.00\" fill=\"rgb(200.000000,65.000000,43.000000)\" visibility=\"visible\"/> \n" +
            "<text x=\"10\" y=\"40\" font-weight=\"bold\" font-size=\"30\">" + SnapID1 + "</text>\n" +
            "<text x=\"10\" y=\"70\" font-size=\"20\">Description: first Snap</text>\n" +
            "</g></svg>\n" +
            "<p></p>\n" +
            "<svg width=\"1000\" height=\"1000\" version=\"1.1\"style =\"border: solid 2px red; background-color:rgb(173,216,230)\"\n" +
            "xmlns=\"http://www.w3.org/2000/svg\">\n" +
            "<g><ellipse id=\"First\" cx=\"20.00\" cy=\"220.00\" rx=\"15.00\" ry=\"15.00\" fill=\"rgb(200.000000,65.000000,43.000000)\" visibility=\"visible\"/> \n" +
            "<rect id=\"Second\" x=\"30.00\" y=\"230.00\" width=\"50.00\" height=\"60.00\" fill=\"rgb(255.000000,98.000000,0.000000)\" visibility=\"visible\" /> \n" +
            "<text x=\"10\" y=\"40\" font-weight=\"bold\" font-size=\"30\">" + SnapID2 + "</text>\n" +
            "<text x=\"10\" y=\"70\" font-size=\"20\">Description: Second Snap</text>\n" +
            "</g></svg>\n" +
            "<p></p>\n" +
            "<svg width=\"1000\" height=\"1000\" version=\"1.1\"style =\"border: solid 2px red; background-color:rgb(173,216,230)\"\n" +
            "xmlns=\"http://www.w3.org/2000/svg\">\n" +
            "<g><ellipse id=\"First\" cx=\"20.00\" cy=\"220.00\" rx=\"15.00\" ry=\"15.00\" fill=\"rgb(200.000000,65.000000,43.000000)\" visibility=\"visible\"/> \n" +
            "<rect id=\"Second\" x=\"30.00\" y=\"230.00\" width=\"50.00\" height=\"60.00\" fill=\"rgb(255.000000,98.000000,0.000000)\" visibility=\"visible\" /> \n" +
            "<ellipse id=\"Third\" cx=\"100.00\" cy=\"290.00\" rx=\"22.50\" ry=\"30.00\" fill=\"rgb(34.000000,56.000000,90.000000)\" visibility=\"visible\"/> \n" +
            "<text x=\"10\" y=\"40\" font-weight=\"bold\" font-size=\"30\">" + SnapID3 + "</text>\n" +
            "<text x=\"10\" y=\"70\" font-size=\"20\">Description: Third Snap</text>\n" +
            "</g></svg>\n" +
            "<p></p>\n" +
            "</body>\n" +
            "</html>");
  }

  /**
   * Test resize shape method.
   */
  @Test
  public void TestResizeShape() {
    this.animationBuilder.createShape("First", "Oval", 10, 10, 30, 30, 0, 255, 0);
    this.animationBuilder.MoveShape("First", 20, 20);
    this.animationBuilder.ColorShape("First", 200, 65, 43);
    this.animationBuilder.ResizeShape("Second", 60, 60);
    this.animationBuilder.SnapShot("first Snap");
    this.animationBuilder.createShape("Second", "Rectangle", 20, 20, 50, 60, 255, 98, 0);
    this.animationBuilder.MoveShape("Second", 30, 30);
    this.animationBuilder.ResizeShape("Second", 40, 40);
    this.animationBuilder.SnapShot("Second Snap");
    this.animationBuilder.createShape("Third", "Oval", 100, 90, 45, 60, 45, 67, 150);
    this.animationBuilder.ColorShape("Third", 34, 56, 90);
    this.animationBuilder.SnapShot("Third Snap");
    this.model = this.animationBuilder.build();
    String SnapID1 = this.model.getSnapshotList().get(0).getSnapShotID();
    String SnapID2 = this.model.getSnapshotList().get(1).getSnapShotID();
    String SnapID3 = this.model.getSnapshotList().get(2).getSnapShotID();
    WebView view = new WebView(this.model, 1000, 1000);
    view.display();
    assertEquals(view.getOutput(),"<!DOCTYPE html>\n" +
            "<html>\n" +
            "<body>\n" +
            "<svg width=\"1000\" height=\"1000\" version=\"1.1\"style =\"border: solid 2px red; background-color:rgb(173,216,230)\"\n" +
            "xmlns=\"http://www.w3.org/2000/svg\">\n" +
            "<g><ellipse id=\"First\" cx=\"20.00\" cy=\"220.00\" rx=\"15.00\" ry=\"15.00\" fill=\"rgb(200.000000,65.000000,43.000000)\" visibility=\"visible\"/> \n" +
            "<text x=\"10\" y=\"40\" font-weight=\"bold\" font-size=\"30\">"+ SnapID1 + "</text>\n" +
            "<text x=\"10\" y=\"70\" font-size=\"20\">Description: first Snap</text>\n" +
            "</g></svg>\n" +
            "<p></p>\n" +
            "<svg width=\"1000\" height=\"1000\" version=\"1.1\"style =\"border: solid 2px red; background-color:rgb(173,216,230)\"\n" +
            "xmlns=\"http://www.w3.org/2000/svg\">\n" +
            "<g><ellipse id=\"First\" cx=\"20.00\" cy=\"220.00\" rx=\"15.00\" ry=\"15.00\" fill=\"rgb(200.000000,65.000000,43.000000)\" visibility=\"visible\"/> \n" +
            "<rect id=\"Second\" x=\"30.00\" y=\"230.00\" width=\"40.00\" height=\"40.00\" fill=\"rgb(255.000000,98.000000,0.000000)\" visibility=\"visible\" /> \n" +
            "<text x=\"10\" y=\"40\" font-weight=\"bold\" font-size=\"30\">" + SnapID2 +"</text>\n" +
            "<text x=\"10\" y=\"70\" font-size=\"20\">Description: Second Snap</text>\n" +
            "</g></svg>\n" +
            "<p></p>\n" +
            "<svg width=\"1000\" height=\"1000\" version=\"1.1\"style =\"border: solid 2px red; background-color:rgb(173,216,230)\"\n" +
            "xmlns=\"http://www.w3.org/2000/svg\">\n" +
            "<g><ellipse id=\"First\" cx=\"20.00\" cy=\"220.00\" rx=\"15.00\" ry=\"15.00\" fill=\"rgb(200.000000,65.000000,43.000000)\" visibility=\"visible\"/> \n" +
            "<rect id=\"Second\" x=\"30.00\" y=\"230.00\" width=\"40.00\" height=\"40.00\" fill=\"rgb(255.000000,98.000000,0.000000)\" visibility=\"visible\" /> \n" +
            "<ellipse id=\"Third\" cx=\"100.00\" cy=\"290.00\" rx=\"22.50\" ry=\"30.00\" fill=\"rgb(34.000000,56.000000,90.000000)\" visibility=\"visible\"/> \n" +
            "<text x=\"10\" y=\"40\" font-weight=\"bold\" font-size=\"30\">" + SnapID3 +"</text>\n" +
            "<text x=\"10\" y=\"70\" font-size=\"20\">Description: Third Snap</text>\n" +
            "</g></svg>\n" +
            "<p></p>\n" +
            "</body>\n" +
            "</html>");
  }

  /**
   * Test command line.
   */
  @Test
  public void TestAlbumWithCommandLine() {
    PhotoAlbumMain.main(new String[]{"-v", "web", "-in", "demo_input.txt",
            "-out", "demo_output.html"});
    List<String> lines;
    try {
      lines = Files.readAllLines(Paths.get("demo_output.html"));
    } catch (IOException e) {
      throw new IllegalArgumentException();
    }

    StringBuilder output = new StringBuilder();
    for (String line: lines) {
      if (line.startsWith("<text")) {
        continue;
      }
      output.append(line);
      output.append("\n");
    }
    assertEquals(output.toString().trim(), "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<body>\n" +
            "<svg width=\"1000\" height=\"1000\" version=\"1.1\"style =\"border: solid 2px red; background-color:rgb(173,216,230)\"\n" +
            "xmlns=\"http://www.w3.org/2000/svg\">\n" +
            "<g><rect id=\"myrect\" x=\"200.00\" y=\"400.00\" width=\"50.00\" height=\"100.00\" fill=\"rgb(255.000000,0.000000,0.000000)\" visibility=\"visible\" /> \n" +
            "<ellipse id=\"myoval\" cx=\"500.00\" cy=\"300.00\" rx=\"30.00\" ry=\"15.00\" fill=\"rgb(0.000000,255.000000,1.000000)\" visibility=\"visible\"/> \n" +
            "</g></svg>\n" +
            "<p></p>\n" +
            "<svg width=\"1000\" height=\"1000\" version=\"1.1\"style =\"border: solid 2px red; background-color:rgb(173,216,230)\"\n" +
            "xmlns=\"http://www.w3.org/2000/svg\">\n" +
            "<g><rect id=\"myrect\" x=\"100.00\" y=\"500.00\" width=\"25.00\" height=\"100.00\" fill=\"rgb(255.000000,0.000000,0.000000)\" visibility=\"visible\" /> \n" +
            "<ellipse id=\"myoval\" cx=\"500.00\" cy=\"300.00\" rx=\"30.00\" ry=\"15.00\" fill=\"rgb(0.000000,255.000000,1.000000)\" visibility=\"visible\"/> \n" +
            "</g></svg>\n" +
            "<p></p>\n" +
            "<svg width=\"1000\" height=\"1000\" version=\"1.1\"style =\"border: solid 2px red; background-color:rgb(173,216,230)\"\n" +
            "xmlns=\"http://www.w3.org/2000/svg\">\n" +
            "<g><rect id=\"myrect\" x=\"100.00\" y=\"500.00\" width=\"25.00\" height=\"100.00\" fill=\"rgb(0.000000,0.000000,255.000000)\" visibility=\"visible\" /> \n" +
            "<ellipse id=\"myoval\" cx=\"500.00\" cy=\"600.00\" rx=\"30.00\" ry=\"15.00\" fill=\"rgb(0.000000,255.000000,1.000000)\" visibility=\"visible\"/> \n" +
            "</g></svg>\n" +
            "<p></p>\n" +
            "<svg width=\"1000\" height=\"1000\" version=\"1.1\"style =\"border: solid 2px red; background-color:rgb(173,216,230)\"\n" +
            "xmlns=\"http://www.w3.org/2000/svg\">\n" +
            "<g><ellipse id=\"myoval\" cx=\"500.00\" cy=\"600.00\" rx=\"30.00\" ry=\"15.00\" fill=\"rgb(0.000000,255.000000,1.000000)\" visibility=\"visible\"/> \n" +
            "</g></svg>\n" +
            "<p></p>\n" +
            "</body>\n" +
            "</html>");
  }
}
