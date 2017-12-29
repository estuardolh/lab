package jbox2d;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.joints.RevoluteJoint;
import org.jbox2d.dynamics.joints.RevoluteJointDef;

public class SandBox extends Thread{
	public JFrame jframe = null;
	World world = null;
	Body body_a = null;
	Body body_e = null;
	Body groundBody = null;
	
	public SandBox(JFrame jframe) {
		this.jframe = jframe;
		
		// Static Body
	    Vec2  gravity = new Vec2(0,80);
	    world = new World(gravity);
	    
	    BodyDef groundBodyDef = new BodyDef();
	    groundBodyDef.position.set(0, 100);
	    
	    groundBody = world.createBody(groundBodyDef);
	    
	    PolygonShape groundBox = new PolygonShape();
	    groundBox.setAsBox(99, 20);
	    
	    groundBody.createFixture(groundBox, 0);
	    
	    
	 // Dynamic Body // E
	    BodyDef bodyDef_e = new BodyDef();
	    bodyDef_e.type = BodyType.DYNAMIC;
	    bodyDef_e.position.set(0, 0);
	    
	    body_e = world.createBody(bodyDef_e);
	    body_e.setAngularVelocity((float)Math.PI);
	    body_e.setAngularDamping((float)Math.PI);
	    PolygonShape dynamicBox_e = new PolygonShape();
	    dynamicBox_e.setAsBox(10, 10);
	    
	    FixtureDef fixtureDef_e = new FixtureDef();
	    fixtureDef_e.shape = dynamicBox_e;
	    fixtureDef_e.density = 4;
	    fixtureDef_e.friction = 0.01f;
	    fixtureDef_e.restitution = 0.7f;
	    
	    
	    body_e.createFixture(fixtureDef_e);
	    body_e.setLinearVelocity(new Vec2(14,10));
	    
	    
	    // Dynamic Body // A
	    BodyDef bodyDef_a = new BodyDef();
	    bodyDef_a.type = BodyType.DYNAMIC;
	    bodyDef_a.position.set(20, 0);
	    
	    body_a = world.createBody(bodyDef_a);
	    
	    PolygonShape dynamicBox_a = new PolygonShape();
	    dynamicBox_a.setAsBox(10, 10);
	    
	    FixtureDef fixtureDef_a = new FixtureDef();
	    fixtureDef_a.shape = dynamicBox_a;
	    fixtureDef_a.density = 1;
	    fixtureDef_a.friction = 0.0004f;
	    fixtureDef_a.restitution = 0.5f;
	    
	    body_a.createFixture(fixtureDef_a);
	    body_a.setLinearVelocity(new Vec2(30,10));
	    
	    RevoluteJointDef jointdef = new RevoluteJointDef();
	    jointdef.initialize(body_e, body_a, new Vec2(60f,0));
	    jointdef.collideConnected = false;
	    
	    RevoluteJoint joint = (RevoluteJoint) world.createJoint(jointdef);
	}
	
	private void update() {
	    // Setup world
	    float timeStep = 1.0f/100.0f;
	    int velocityIterations = 6;
	    int positionIterations = 2;
		
		world.step(timeStep, velocityIterations, positionIterations);
		
        /*Vec2 position = body_a.getPosition();
        float angle = body_a.getAngle();
        
        System.out.printf("x=%4.2f, y=%4.2f\n", position.x, position.y, angle);*/
	}
	private void draw() {
		jframe.getContentPane().removeAll();
		
		Vec2 position_ground = groundBody.getPosition();
		PictureBox picturebox = new PictureBox(Color.BLACK);
		picturebox.cw =(int)toPixels(100);
		picturebox.ch = (int)toPixels(20);
		picturebox.cx = (int)toPixels(0);
		picturebox.cy = (int)toPixels(80);
		picturebox.setDegrees(groundBody.getAngle());
		picturebox.setBounds(picturebox.cx, picturebox.cy, picturebox.cw, picturebox.ch);
		jframe.getContentPane().add(picturebox);
		
		Vec2 position_body_e = body_e.getPosition();
		PictureBox pic_e = new PictureBox(Color.GREEN.darker());
		pic_e.cw =(int)toPixels(10);
		pic_e.ch = (int)toPixels(10);
		pic_e.cx = (int)toPixels(position_body_e.x);
		pic_e.cy = (int)toPixels(position_body_e.y);
		pic_e.setDegrees(body_e.getAngle());
		pic_e.setOpaque(false);
		System.out.println("angle E: "+body_e.getAngle());
		pic_e.setBounds(pic_e.cx, pic_e.cy, pic_e.cw, pic_e.ch);
		jframe.getContentPane().add(pic_e);
		
		Vec2 position_body_a = body_a.getPosition();
		PictureBox pic_a = new PictureBox(Color.RED.darker());
		pic_a.cw =(int)toPixels(10);
		pic_a.ch = (int)toPixels(10);
		pic_a.cx = (int)toPixels(position_body_a.x);
		pic_a.cy = (int)toPixels(position_body_a.y);
		pic_a.setDegrees(body_a.getAngle());
		pic_a.setBounds(pic_a.cx, pic_a.cy, pic_a.cw, pic_a.ch);
		jframe.getContentPane().add(pic_a);
		
		jframe.getContentPane().revalidate();
		jframe.getContentPane().repaint();
	}
	
	@Override
	public void run() {
		for(;;) {
			update();
			draw();
			
			try {
				Thread.sleep(10);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private float toPixels(float metres) {
		return metres * 2;
	} 
}

