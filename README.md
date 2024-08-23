#  Java Photo Album
The four packages- controller, model, utility and view divide the program by the functions of the MVC and helper functions. 
The controller contains GraphicalController and WebController and a common IController interface. The controllers instantiate the CommandReader file that parses though the instruction txt file, gets snapshots using the model and then outputs the view with these snapshots. 
PictureModel(the model spoken of above) has the ability to modify shapes, add them to a list of 'shapes' and process them to a list of 'snapshots'.
The classes (abstract) Shape extends to Rectangle, Oval and DifferentShape that are able to get and set features of these shapes of size, position and color. Shapetype is an enum used to classify shapes. 
The graphical view is created with Swing and makes snapshots based on inputs. It always draws next, previous, select and quit buttons to navigate the program. 
The WebView creates static outputs of the frames of snapshots. 
The only modification make to PictureModel was to process color inputs as RGB values rather than as strings. 

The program may be run by opening the file with the 'resources' folder and running:
java -jar shape_draw.jar -in [filename].txt -v graphical -out [int: window height] [int: window length]
OR
java -jar shape_draw.jar -in [filename].txt -view web -out [filename].html
If this fails for whatever reason, there is a commented out section at the bottom of PhotoAlbumMain that can be uncommented (and comment the section above) and then run from the main directly the files provided in the starter files. 
