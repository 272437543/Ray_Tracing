package computer_graphics_6;

public abstract class Light {//��ĸ���
	//public Vector3 L;//����
	//public Colors irradiance;//��ɫ
	public abstract void init();//��ʼ������
	public abstract LightSample sample(Union union, Vector3 position);//��������
}
