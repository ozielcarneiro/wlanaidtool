RUNNING THE PROGRAM:

To run the program from the command line, go to the dist folder and
type the following:

java -jar "AplicacaoRedes.jar" 

or Double-Click AplicacaoRedes.jar file

USING THE PROGRAM:

The program Graphic User Interface is written in portuguese, so this section will clarify the usage of the program

1 - Wall File specification:

To use the program initially it is necessary a text file containing the floor size, the walls coordinates and types. The program is able to work with two types of walls: i) Brick Walls; and ii) Drywalls. The data in the file is divided into lines. The first line contains the size (width,height) of the floor (in meters) used for analysis. The subsequent lines are the walls specifications, where each line corresponds to a wall. The wall specification consists of 5 items. The first four items are coordinates for the beginning and end of the wall, and the last item is a word specifying the type of the wall (TIJ for brick walls, and DIV for drywalls). After the walls no more data needs to be specified, so the end of the file indicates the end of the "blueprint" data. To illustrate how the file should be constructed bellow is an example of a 24.35 by 12.6 floor with brick walls delimiting the perimeter and a horizontal drywall:

24.35,12.6
0, 0, 24.35, 0,TIJ
0, 0, 0, 12.6,TIJ
0, 12.6, 24.35, 12.6,TIJ
24.35, 12.6, 24.35, 0,TIJ
0, 9.97, 1.85, 9.97,DIV

After specifying the walls file a blueprint is drawn in a new pop-up window that will show the coverage map.

2 - Model Selection:

The program was intended to allow the user to use either a propagation model proposed by Ph. D. Simone Fraiha called Padé or a Radial Basis Function Network to extrapolate measured data. However only the propagation model method was implemented. So the field "Modelo" should show Pade for proper functioning. Then the user needs to specify the access points locations by clicking in "Adicionar". This will trigger three pop-up questions to obtain the coordinates (in meters), the Power (in dB), and the antenna gain (in dB). So the first question answer is the coordinates (x,y,z) of the AP, which have to be entered together separated by commas. The next two questions answers are single numbers indicating the Power and antenna gain. An example of answers would be as following:
i) 1,4,1.18
ii) 18
iii) 5
This would create an item (1.0,4.0,1.18) 18.0dB+5.0dB in the access point list.

Multiple access points can be added to the analysis, and can also be removed, by selecting the corresponding item in the list and then clicking in "Remover".

After adding or removing an access point the blue print drawn is updated with the new coverage map corresponding to the actual configuration of the environment. If no access point is present the drawing goes back to the "empty" blue print.

3 - Coverage Map

The coverage map is a heat map plot over the blue print. The color scale is determined dynamically using the minimum and maximum values of the probability of signal reception in area, these values are indicated in the scale. Then each point is colored with the respective color indicating the probability of reception in the point. For every change made in the access point list the map is updated.
