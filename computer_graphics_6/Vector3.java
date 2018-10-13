package computer_graphics_6;

public class Vector3{//��ά������Ҳ���Դ���ռ��еĵ㣩
	public float x,y,z;
	public float[] angle;
	public Vector3() 
	{
		x=y=z=0;
	}
	public Vector3 copy(Vector3 clone)
	{
		return new Vector3(clone.x, clone.y, clone.z);
	}
	public Vector3(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public void Set(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public float Length()//����
	{
		return (float) Math.sqrt(x*x+y*y+z*z);
	}
	public Vector3 normalize()//ʹ����Ϊ1����Ϊ��λ����
	{
		return new Vector3(x / Length(), y / Length(), z / Length());
	}
	public Vector3 add(Vector3 vec)//��
	{
		return new Vector3(this.x + vec.x,this.y + vec.y,this.z + vec.z);
	}
	public Vector3 subtract(Vector3 vec)//��
	{
		return new Vector3(this.x - vec.x,this.y - vec.y,this.z - vec.z);
	}
	public Vector3 multi(float m)//��������
	{
		return new Vector3(this.x*m, this.y*m, this.z*m);
	}
	public Vector3 devide(float d)
	{
		float ind = 1f / d;
		return new Vector3(x * ind, y*ind, z*ind);
	}
	public float dot(Vector3 vec)//�������
	{
		return vec.x*x + vec.y*y + vec.z*z;
	}
	public Vector3 cross(Vector3 v)//�������
	{
		return new Vector3(-this.z * v.y + this.y * v.z, this.z * v.x - this.x * v.z, -this.y * v.x + this.x * v.y);
	}
	public Vector3 negate()//������
	{
		return new Vector3(-x, -y, -z);
	}
	public static final Vector3 zero()//0����
	{
		return new Vector3();
	}
	public String toString()
	{
		return "["+x+" "+y+" "+z+"]";
	}
	public static float distance( Vector3  a,  Vector3 b)
	{
		Vector3 offset = a.subtract(b);
		return offset.Length();
	}
	public static final Vector3 forward()
	{
		return new Vector3(0, 0, 0.2f);
	}
	public static final Vector3 up()
	{
		return new Vector3(0, 0.2f, 0);
	}
	public static final Vector3 right()
	{
		return new Vector3(0.2f, 0, 0);
	}
	public float[] getAngle()//����������
	{//����ı����ǵ�λ����
		angle = new float[2];
		angle[0] = (float) (Math.atan2(z, x));
		float length = (float) Math.sqrt(z*z+x*x);
		angle[1] = (float) (Math.atan2(y, length));
		return angle;//angle[0]��ˮƽ���ꡣangle[1]����ֱ����
	}
	public Vector3 HorizonRotate(float angle)
	{// TODO ��һ�˳�ת����
		float ang = (float) Math.atan2(z, x);//PI
		ang += angle;
		//ֻ��x��y
		return new Vector3((float)Math.cos(ang), y, (float)Math.sin(ang));
	}
	public Vector3 setRotation(float Horizontal, float Vertical)
	{
		float y = (float) Math.sin(Vertical);
		float length = (float) Math.cos(Vertical);
		float x = (float) Math.cos(Horizontal) * length;
		float z = (float) Math.sin(Horizontal) * length;
		//return new Vector3(zero(x)*zero(x), zero(y)*zero(y), zero(z)*zero(z));
		return new Vector3(x,y,z);
	}
	public Vector3 Rotate(float Horizontal, float Vertical)
	{// TODO ����ˮƽ����ֱ�Ƕȣ�������ת
		float[] angle = getAngle();
		return setRotation(angle[0]+Horizontal, angle[1]+Vertical);
	}
	@Override
	public boolean equals(Object obj) {
		Vector3 v = (Vector3) obj;
		return zero(v.x-x)&&zero(v.z-z)&&zero(v.z-z);
	}
	private boolean zero(float f)
	{
		return Math.abs(f)<0.0001f;
	}
//	public static void main(String[] s)
//	{
//		Vector3 v = new Vector3(0, 1, 0);
//		System.out.println(v.setRotation((float)Math.PI, 0));
//	}
}
