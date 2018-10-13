package computer_graphics_6;

import java.awt.Color;

public class Colors {
	public float r,g,b;
	public Colors(Colors c)
	{
		this.r = c.r;
		this.g = c.g;
		this.b = c.b;
	}
	public Colors(Color c)
	{
		this.r = (float)c.getRed() / 255f;
		this.g = (float)c.getGreen() / 255f;
		this.b = (float)c.getBlue() / 255f;
	}
	public Colors(float r, float g, float b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	public Colors() {
		r=g=b=0;
	}
	public Colors copy()
	{
		return new Colors(r,g,b);
	}
	public Colors add(Colors a)
	{
		return new Colors(r+a.r, g+a.g, b+a.b);
	}
	public Colors multi(float s)
	{
		return new Colors(r*s, g*s, b*s);
	}
	public Colors modulate(Colors c)//调和颜色
	{
		return new Colors(this.r * c.r, this.g * c.g, this.b * c.b);
	}
	public Colors modulate(Vector3 c)
	{
		return new Colors(this.r * c.x, this.g * c.y, this.b * c.z);
	}
	public String toString()
	{
		return "[ R: "+r+" G: "+g+" B: "+b+" ]";
	}
	@Override
	public boolean equals(Object obj) {
		Colors c = (Colors) obj;
		return zero(c.r - r) && zero(c.b - b) && zero(c.g - g);
	}
	private boolean zero(float f)
	{
		return Math.abs(f)<=0.0001f;
	}
	public int legel()
	{
		if(r>1 || g>1 || b>1)return 1;//超上限
		if(r<0 || g<0 || b<0)return -1;//超下限
		return 0;
	}
}
