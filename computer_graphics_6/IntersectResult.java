package computer_graphics_6;

public class IntersectResult {
	public SceneObject Object;//��ײ����
	public float distance;   //��ײ���������ľ���
	public Vector3 position; //��ײ���λ��
	public Vector3 normal;   //��ײ��ķ�����
	public IntersectResult() {
		Object = null;
		distance = 0f;
		position = new Vector3();
		normal = new Vector3();
	}
	public IntersectResult NoHit()
	{
		return new IntersectResult();
	}
}
