package utilsPkg;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import mainPkg.Defines;
import mainPkg.JTetris;

public class KeyHandler {
	public boolean pressedEscape;
	public int direction; // -1 = left, 0 = nothing, 1 = male
	public boolean rotating; // 1 = rotating, 0 = not rotating
	
	private PressedEsc pe;

	private PressedW pw;
	private PressedD pd;
	private PressedS ps;
	private PressedA pa;

	private ReleasedS rs;
	
	
	public KeyHandler() {
		this.pressedEscape = false;
		this.direction = 0;
		this.rotating = false;
		
		pe = new PressedEsc();
		
		pw = new PressedW();
		pd = new PressedD();
		ps = new PressedS();
		pa = new PressedA();

		rs = new ReleasedS();
	}
	
	public void handleKeys(JTetris jtetris) {
		jtetris.getInputMap(Defines.IFW).put(KeyStroke.getKeyStroke("ESCAPE"), "escape");
		jtetris.getInputMap(Defines.IFW).put(KeyStroke.getKeyStroke("ENTER"), "escape");
		
		jtetris.getInputMap(Defines.IFW).put(KeyStroke.getKeyStroke("W"), "w");
		jtetris.getInputMap(Defines.IFW).put(KeyStroke.getKeyStroke("D"), "d");
		jtetris.getInputMap(Defines.IFW).put(KeyStroke.getKeyStroke("S"), "s");
		jtetris.getInputMap(Defines.IFW).put(KeyStroke.getKeyStroke("A"), "a");

		jtetris.getInputMap(Defines.IFW).put(KeyStroke.getKeyStroke("UP"), "w");
		jtetris.getInputMap(Defines.IFW).put(KeyStroke.getKeyStroke("RIGHT"), "d");
		jtetris.getInputMap(Defines.IFW).put(KeyStroke.getKeyStroke("DOWN"), "s");
		jtetris.getInputMap(Defines.IFW).put(KeyStroke.getKeyStroke("LEFT"), "a");

		jtetris.getInputMap(Defines.IFW).put(KeyStroke.getKeyStroke("released S"), "released_s");
		jtetris.getInputMap(Defines.IFW).put(KeyStroke.getKeyStroke("released DOWN"), "released_s");
		
		jtetris.getActionMap().put("escape", pe);
		jtetris.getActionMap().put("w", pw);
		jtetris.getActionMap().put("d", pd);
		jtetris.getActionMap().put("s", ps);
		jtetris.getActionMap().put("released_s", rs);
		jtetris.getActionMap().put("a", pa);
	}
	
	public class PressedEsc extends AbstractAction{
		@Override
		public void actionPerformed(ActionEvent e) {
			pressedEscape = true;
		}
	}
	
	public class PressedW extends AbstractAction{
		@Override
		public void actionPerformed(ActionEvent e) {
			rotating = true;
		}
	}
	
	public class PressedD extends AbstractAction{
		@Override
		public void actionPerformed(ActionEvent e) {
			direction = 1;
		}
	}
	
	public class PressedS extends AbstractAction{
		@Override
		public void actionPerformed(ActionEvent e) {
			Defines.waiting = Defines.FPS/10;
		}
	}

	public class ReleasedS extends AbstractAction{
		@Override
		public void actionPerformed(ActionEvent e) {
			Defines.waiting = Defines.FPS;
		}
		
	}
	
	public class PressedA extends AbstractAction{
		@Override
		public void actionPerformed(ActionEvent e) {
			direction = -1;
		}
	}
}

















