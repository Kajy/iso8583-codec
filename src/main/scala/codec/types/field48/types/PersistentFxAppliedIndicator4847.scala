package codec.types.field48.types

import codec.FieldCodecs.LLVAR_N
import codec.types.field48.PrivateData48XX
import scodec.*

case class PersistentFxAppliedIndicator4847(isApplied: Boolean) extends PrivateData48XX

object PersistentFxAppliedIndicator4847 {

  val codec: Codec[PersistentFxAppliedIndicator4847] = LLVAR_N
    .xmap[Boolean](_ != "00", b => if (b) "01" else "00")
    .as[PersistentFxAppliedIndicator4847]

}
