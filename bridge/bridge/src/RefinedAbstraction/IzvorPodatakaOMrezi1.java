package RefinedAbstraction;

import Abstraction.IzvorPodatakaOMrezi;
import Implementor.GeneratorMreze;
import ConcreteImplementor.SlucajniGeneratorMreze;

public class IzvorPodatakaOMrezi1 extends IzvorPodatakaOMrezi // RefinedAbstraction
{
    @Override
    protected GeneratorMreze vratiGenerator() { return new SlucajniGeneratorMreze(); } // Promenljivo!!!
}
