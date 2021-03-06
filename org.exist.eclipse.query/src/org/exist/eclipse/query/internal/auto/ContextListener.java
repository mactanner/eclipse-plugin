/**
 * 
 */
package org.exist.eclipse.query.internal.auto;

import org.exist.eclipse.IConnection;
import org.exist.eclipse.auto.connection.AutoContextRegistration;
import org.exist.eclipse.listener.IConnectionListener;

/**
 * The ContextListener is involved if a connection is opened or closed. It
 * informs the AtuoContextRegistration in the auto plugin in case of a change
 * related to the connections.
 * 
 * @author Markus Tanner
 */
public class ContextListener implements IConnectionListener {

	public void opened(IConnection connection) {
		AutoContext autoContext = new AutoContext(connection);
		AutoContextRegistration.getInstance().add(autoContext);
	}

	public void closed(IConnection connection) {
		AutoContext autoContext = new AutoContext(connection);
		AutoContextRegistration.getInstance().remove(autoContext);
	}

	public void added(IConnection connection) {
		// do nothing
	}

	public void removed(IConnection connection) {
		// do nothing
	}

}
