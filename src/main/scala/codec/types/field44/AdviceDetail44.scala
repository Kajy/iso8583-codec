package codec.types.field44

import codec.FieldCodecs.*
import scodec.Codec
import scodec.codecs.*

case class AdviceDetail44(
    RA: Option[String],
    RB: Option[String],
    RC: Option[String]
) {
  override def toString: String = s"RA: ${RA}, RB: ${RB}, RC: ${RC}"
}

object AdviceDetail44 {

  val codec: Codec[AdviceDetail44] = list(TLV(AN(2), AN_INT(2), AN))
    .xmap(
      fields => {
        val RA = fields.find(_._1 == "RA").map(_._2)
        val RB = fields.find(_._1 == "RB").map(_._2)
        val RC = fields.find(_._1 == "RC").map(_._2)

        AdviceDetail44(RA, RB, RC)
      },
      (ad: AdviceDetail44) =>
        List.concat(
          ad.RA.map("RA" -> _),
          ad.RB.map("RB" -> _),
          ad.RC.map("RC" -> _)
        )
    )

}
