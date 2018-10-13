import java.io.FileOutputStream

import org.apache.uima.fit.factory.AnalysisEngineFactory

object GenerateXML extends App{
  val aed = AnalysisEngineFactory.createEngineDescription(
    classOf[QuickAE]
  )
  aed.toXML(new FileOutputStream("QuickAE.xml"))
}