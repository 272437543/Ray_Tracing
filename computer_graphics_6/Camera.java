package computer_graphics_6;

public class Camera {
	Vector3 eye, front, refup, up, right;
	float fov, fovScale;
	public Camera(Vector3 eye, Vector3 front, Vector3 up, float fov) {
		//�����ǣ�λ�ã��Ƕȣ���б�ȣ���Ұ
		this.eye = eye;
		this.front = front;
		this.refup = up;
		this.fov = fov;
	}
	void init()//��ʼ�������
	{
		right = front.cross(refup);
		up = right.cross(front);
		fovScale = (float) (Math.tan(fov * 0.5 * Math.PI / 180) * 2);
	}
	Ray3 generateRay(float x, float y)//�������ص�λ��(����ڻ�����)����һ������
	{
		Vector3 r = right.multi((x - 0.5f) * fovScale);
		Vector3 u = up.multi((y - 0.5f)*fovScale);
		return new Ray3(eye, front.add(r).add(u).normalize());
	}
}
