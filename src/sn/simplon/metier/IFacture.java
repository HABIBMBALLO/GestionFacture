package sn.simplon.metier;

import sn.simplon.entities.Facture;

import java.util.List;

public interface IFacture {
    public int add(Facture f);
    public List<Facture> liste();
    public int update(Facture f);
}
