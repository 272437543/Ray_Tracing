package computer_graphics_6;

public class IntersectResult {
	public SceneObject Object;//碰撞物体
	public float distance;   //碰撞点和摄像机的距离
	public Vector3 position; //碰撞点的位置
	public Vector3 normal;   //碰撞点的法向量
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
