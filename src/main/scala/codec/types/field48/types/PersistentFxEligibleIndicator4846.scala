package codec.types.field48.types

import codec.FieldCodecs.TLV_N
import codec.types.field48.PrivateData48XX
import scodec.*

case class PersistentFxEligibleIndicator4846(isEligible: Boolean) extends PrivateData48XX

object PersistentFxEligibleIndicator4846 {

  val codec: Codec[PersistentFxEligibleIndicator4846] = TLV_N(1)
    .xmap[Boolean](_ > 0, b => if (b) 1 else 0)
    .as[PersistentFxEligibleIndicator4846]

}
