package Interface;

import java.util.List;

import Model.Padre;

public interface PadresInterface {
	public void RegistrarPadres(Padre pad);
	public void ActualizarPadres(Padre pad);
	public Padre BuscarPadre(Padre pad);
	public List<Padre> ListadoPadres();
}
