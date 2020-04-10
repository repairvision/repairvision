package org.sidiff.graphpattern.csp.generic.impl.domain;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Stack;

import org.sidiff.graphpattern.csp.generic.IDomain;
import org.sidiff.graphpattern.csp.generic.IVariable;

public class Domain<D> implements IDomain<D> {
	
	public static final ValueColor VISIBLE = new ValueColor() {
		
		@Override
		public boolean isVisible() {
			return true;
		}
		
		@Override
		public String getName() {
			return "visible";
		}
	};
	
	public static final ValueColor INVISIBLE = new ValueColor() {
		
		@Override
		public boolean isVisible() {
			return false;
		}
		
		@Override
		public String getName() {
			return "invisible";
		}
	};
	
	protected LinkedHashMap<D, ValueColor> values;
	
	protected int size = 0;
	
	protected int visible = 0;
	
	protected Stack<ValueRestriction<D>> restrictions;
	
	protected ValueColor visibleIColor = VISIBLE;
	
	protected ValueColor invisibleIColor = INVISIBLE;
	
	public Domain() {
		this.values = new LinkedHashMap<D, ValueColor>();
		this.restrictions = new Stack<>();
	}
	
	public Domain(int size) {
		this.values = new LinkedHashMap<D, ValueColor>((int) ((float) size / 0.75f + 1.0f));
		this.restrictions = new Stack<>();
	}
	
	@SafeVarargs
	public Domain(D... values) {
		this(values.length);
		
		for (D value : values) {
			add(value);
		}
	}
	
	public void add(D value) {
		add(value, VISIBLE);
	}
	
	public void add(D value, ValueColor color) {
		values.put(value, color);
		++size;
		++visible;
	}

	public void setVisibleIColor(ValueColor visibleIColor) {
		this.visibleIColor = visibleIColor;
	}
	
	public ValueColor getVisibleIColor() {
		return visibleIColor;
	}
	
	public void setInvisibleIColor(ValueColor invisibleIColor) {
		this.invisibleIColor = invisibleIColor;
	}
	
	public ValueColor getInvisibleIColor() {
		return invisibleIColor;
	}
	
	@Override
	public Iterator<D> iterator() {
		return new VisibileIteration<D>(this);
	}

	@Override
	public void applyRestriction(IVariable<?, D> origin, D value) {
		ValueColor color = values.get(value);

		// is restriction necessary?
		if ((color != null) && color.isVisible()) {
			makeInvisible(value);
			restrictions.push(new ValueRestriction<>(origin, value));
		}
	}

	@Override
	public void undoRestriction(IVariable<?, D> origin) {
		
		// revert the selection:
		if (!restrictions.isEmpty()) {
			ValueRestriction<D> lastRestriction = restrictions.lastElement();
			
			while (!restrictions.isEmpty() && (lastRestriction.getSource() == origin)) {
				makeVisible(lastRestriction.getRestriction());
				restrictions.pop();
			}
		}
	}

	@Override
	public boolean isEmpty() {
		return (visible == 0);
	}
	
	protected void makeVisible(D value) {
		ValueColor previousIColor = values.put(value, visibleIColor);
		
		if (!previousIColor.isVisible()) {
			++visible;
		}
	}
	
	protected void makeInvisible(D value) {
		ValueColor previousIColor = values.put(value, invisibleIColor);
		
		if (previousIColor.isVisible()) {
			--visible;
		}
	}
	
	public int getVisibleSize() {
		return visible;
	}
	
	public int getInvisibleSize() {
		return size - visible;
	}
	
	public int size() {
		return size;
	}
}
