import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Diese Klasse implementiert das Interface VerleihService. Es handelt sich
 * lediglich um eine Dummy-Implementation, um die GUI zu testen.
 * 
 * @author GUI-Team
 * @version SoSe 2017
 */
class DummyVerleihService extends AbstractObservableService
        implements VerleihService
{
    // Generator für Zufallszahlen und zufällige boolsche Werte
    private static final Random RANDOM = new Random();

    private static final CD MEDIUM = new CD("Titel", "Kommentar", "Interpret",
            70);
    private static final Kundennummer KUNDENNUMMER = new Kundennummer(123456);
    private static final Kunde ENTLEIHER = new Kunde(KUNDENNUMMER, "Vorname",
            "Nachname");
    private static final Verleihkarte VERLEIHKARTE = new Verleihkarte(ENTLEIHER,
            MEDIUM, Datum.heute());

    public DummyVerleihService(KundenstammService kundenstamm,
            MedienbestandService medienbestand,
            List<Verleihkarte> initialBestand)
    {
    }

    /**
     * Liefert eine Liste mit einem konstanten Eintrag zurück anstelle aller ausgeliehender Medien für einen Kunden
     */
    @Override
    public List<Medium> getAusgelieheneMedienFuer(Kunde kunde)
    {
        List<Medium> ergebnisListe = new ArrayList<Medium>();
        ergebnisListe.add(MEDIUM);
        return ergebnisListe;
    }

    /**
     * Gibt konstanten Kunden zurück
     */
    @Override
    public Kunde getEntleiherFuer(Medium medium)
    {
        return ENTLEIHER;
    }

    /**
     * Gibt konstante Verleihkarte zurück
     */
    @Override
    public Verleihkarte getVerleihkarteFuer(Medium medium)
    {
        return VERLEIHKARTE;
    }

    /**
     * Liefert eine Liste mit einem konstanten Eintrag zurück anstelle der Liste aller Verleihkarten
     */
    @Override
    public List<Verleihkarte> getVerleihkarten()
    {
        List<Verleihkarte> ergebnisListe = new ArrayList<Verleihkarte>();
        ergebnisListe.add(VERLEIHKARTE);
        return ergebnisListe;
    }

    /**
     * Gibt einen Zufallsboolean zurück
     */
    @Override
    public boolean istVerliehen(Medium medium)
    {
        return RANDOM.nextBoolean();
    }

    /**
     * Hat keine Funktion
     */
    @Override
    public void nimmZurueck(List<Medium> medien, Datum rueckgabeDatum)
    {
    }

    /**
     * Gibt einen Zufallsboolean zurück
     */
    @Override
    public boolean sindAlleNichtVerliehen(List<Medium> medien)
    {
        return RANDOM.nextBoolean();
    }

    /**
     * Gibt einen Zufallsboolean zurück
     */
    @Override
    public boolean sindAlleVerliehen(List<Medium> medien)
    {
        return RANDOM.nextBoolean();
    }

    /**
     * Hat keine Funktion
     */
    @Override
    public void verleiheAn(Kunde kunde, List<Medium> medien, Datum ausleihDatum)
    {
    }

    /**
     * Prüft nicht gegen Kundenstamm sondern gegen konstanten Kunden
     */
    @Override
    public boolean kundeImBestand(Kunde kunde)
    {
        return ENTLEIHER.equals(kunde);
    }

    /**
     * Prüft nicht gegen Medienbestand sondern gegen konstantes Medium
     */
    @Override
    public boolean mediumImBestand(Medium medium)
    {
        return MEDIUM.equals(medium);
    }

    /**
     * Prüft Medien aus Liste gegen konstantes Medium und nicht gegen Bestandsliste ab
     */
    @Override
    public boolean medienImBestand(List<Medium> medien)
    {
        boolean result = true;
        for (Medium medium : medien)
        {
            if (!mediumImBestand(medium))
            {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Liefert eine Liste mit einem konstanten Eintrag zurück anstelle der Verleihkarten für einen Kunden
     */
    @Override
    public List<Verleihkarte> getVerleihkartenFuer(Kunde kunde)
    {
        List<Verleihkarte> result = new ArrayList<Verleihkarte>();
        result.add(VERLEIHKARTE);
        return result;
    }
    
    /**
     * Returned immer false anstelle tatsächlichem Ergebnis
     */
    @Override
    public boolean istVerleihenMoeglich(Kunde kunde, List<Medium> medien)
    {
        return false;
    }
}
