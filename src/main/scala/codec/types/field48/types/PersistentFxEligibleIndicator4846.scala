package codec.types.field48.types

import codec.FieldCodecs.LLVAR_N
import codec.types.field48.PrivateData48XX
import scodec.*

case class PersistentFxEligibleIndicator4846(isEligible: Boolean) extends PrivateData48XX

object PersistentFxEligibleIndicator4846 {

  val codec: Codec[PersistentFxEligibleIndicator4846] = LLVAR_N
    .xmap[Boolean](_ != "00", b => if (b) "01" else "00")
    .as[PersistentFxEligibleIndicator4846]

}
