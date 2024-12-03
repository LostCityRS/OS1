package jagex2.client;

import java.awt.*;

public class ViewBox extends Frame {

	public Insets insets;

	public ViewBox(int width, int height) {
		this.setTitle("Jagex");
		this.setResizable(false);
		this.show();
		this.toFront();
		this.insets = this.getInsets();
		this.setSize(width + this.insets.left + this.insets.bottom, height + this.insets.top + this.insets.bottom);
	}
}
