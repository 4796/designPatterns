package Strategy;

import AbstractProductC.IzvorPodataka;

public interface NacinSimulacije {
    String simuliraj(IzvorPodataka ip, boolean fokusSemafori, int brojTrenutnogKruga);
}
