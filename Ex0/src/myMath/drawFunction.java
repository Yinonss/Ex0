package myMath;

import javax.swing.JFrame;
import de.erichseifert.gral.data.DataTable;
import java.awt.Color;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.ui.InteractivePanel;

/**This class is creating the functions graph.
 * In this class i used code which helped me build the graph which include
 * adding "gral" library.
 * source : https://github.com/eseifert/gral/wiki/download
 * This class also prints the max / min points of the graph and compute the
 * area between this function and x axis (for x0=-2 , x1=6).
 * @author yinon
 *
 */
public class drawFunction extends JFrame {
	  double min=0,max=0,eps=0.01;
	  boolean first=true,last=true;
	  double f,l;
      public drawFunction(Polynom_able p) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        // Insert rest of the code here

        DataTable data = new DataTable(Double.class, Double.class);
        for (double x = -2; x <= 6; x+=0.01) {
           double y = p.f(x);
          if(y<min)
        	   min=y;
           if(y>max)
        	   max=y;
           if((first)&&(y<=0)) {
        	   f=x;
        	   first=false; 
           }
           if((last==true)&&(y>=0)&&(first==false)) {
        	   l=x;
               last=false;
           }
           data.add(x,y);
        }
        XYPlot plot = new XYPlot(data);
        getContentPane().add(new InteractivePanel(plot));
        LineRenderer lines = new DefaultLineRenderer2D();
        plot.setLineRenderers(data, lines);
        Color color = new Color(0.0f, 0.3f, 1.0f);
        plot.getPointRenderers(data).get(0).setColor(color);
        plot.getLineRenderers(data).get(0).setColor(color);
        System.out.println("Max : "+max);
        System.out.println("Min : "+min);
        System.out.println("Area : "+p.area(f, l, eps));
      }
   
}
