package RefinedAbstraction;

import Abstraction.IzvorPodatakaOVozilima;
import Implementor.GeneratorMreze;
import ConcreteImplementor.SlucajniGeneratorMreze;

public class IzvorPodatakaOVozilima1 extends IzvorPodatakaOVozilima // RefinedAbstraction
{
    @Override
    protected GeneratorMreze vratiGenerator() { return new SlucajniGeneratorMreze(); } // Promenljivo!!!
}
