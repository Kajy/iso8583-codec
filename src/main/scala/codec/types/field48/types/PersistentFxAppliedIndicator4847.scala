package codec.types.field48.types

import codec.FieldCodecs.TLV_N
import codec.types.field48.PrivateData48XX
import scodec.*

case class PersistentFxAppliedIndicator4847(isApplied: Boolean) extends PrivateData48XX

object PersistentFxAppliedIndicator4847 {

  val codec: Codec[PersistentFxAppliedIndicator4847] = TLV_N(1)
    .xmap[Boolean](_ > 0, b => if (b) 1 else 0)
    .as[PersistentFxAppliedIndicator4847]

}
