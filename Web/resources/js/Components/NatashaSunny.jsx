import natashaavatar from "../assets/natashaavatar.png";
import IconPin from "../assets/icon-pin.svg";

export default function NatashaSunny() {
    return (
        <div className="bg-[url('../js/assets/natashasunny.png')] h-[500px] w-[500px] flex">
            <div className="flex">
                <div className="flex justify-start pt-[16px] pl-[16px]">
                    <div className="bg-white/30 w-[151px] flex items-center h-[40px] px-2 gap-x-3 rounded-[100px] backdrop-blur-lg">
                        <img src={natashaavatar} className="rounded-full" />
                        <p className="text-[#0F1017] text-[12px]">
                            Natasha Sunny
                        </p>
                    </div>
                </div>

                <div className="flex justify-end pt-[24px] pr-[24px]">
                    <div className="bg-[#6673EA] w-[24px] h-[24px] rounded-full flex items-center justify-center">
                        <img src={IconPin} />
                    </div>
                </div>
            </div>
        </div>
    );
}
