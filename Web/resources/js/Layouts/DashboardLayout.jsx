import ApplicationLogo from "@/Components/ApplicationLogo";
import NavLink from "@/Components/NavLink";
import { Link } from "@inertiajs/react";

export default function DashboardLayout({ user, header, children }) {
    return (
        <div className="min-h-screen bg-whit flex flex-row">
            <div className="h-screen w-[280px] bg-zinc-700">
                <div className="pl-6 py-6">
                    <div className="flex gap-x-4 items-center">
                        <ApplicationLogo className="h-10" />
                        <h1 className="font-medium text-xl">yttaygy</h1>
                    </div>

                    <div className="pt-16">
                        <ul className="grid gap-y-7">
                            <li>
                                <NavLink
                                    className="flex gap-x-3 items-center"
                                    href={route("dashboard")}
                                    active={route().current("dashboard")}
                                >
                                    <svg
                                        xmlns="http://www.w3.org/2000/svg"
                                        fill="none"
                                        viewBox="0 0 24 24"
                                        stroke-width="1.5"
                                        stroke="currentColor"
                                        class="w-8 h-8"
                                    >
                                        <path
                                            stroke-linecap="round"
                                            stroke-linejoin="round"
                                            d="M13.5 16.875h3.375m0 0h3.375m-3.375 0V13.5m0 3.375v3.375M6 10.5h2.25a2.25 2.25 0 002.25-2.25V6a2.25 2.25 0 00-2.25-2.25H6A2.25 2.25 0 003.75 6v2.25A2.25 2.25 0 006 10.5zm0 9.75h2.25A2.25 2.25 0 0010.5 18v-2.25a2.25 2.25 0 00-2.25-2.25H6a2.25 2.25 0 00-2.25 2.25V18A2.25 2.25 0 006 20.25zm9.75-9.75H18a2.25 2.25 0 002.25-2.25V6A2.25 2.25 0 0018 3.75h-2.25A2.25 2.25 0 0013.5 6v2.25a2.25 2.25 0 002.25 2.25z"
                                        />
                                    </svg>
                                    <span className="text-[15px] font-normal">
                                        Dashboard
                                    </span>
                                </NavLink>
                            </li>

                            <li>
                                <NavLink
                                    className="flex gap-x-3 items-center border-none"
                                    href={route("Event")}
                                    active={route().current("Event")}
                                >
                                    <svg
                                        xmlns="http://www.w3.org/2000/svg"
                                        fill="none"
                                        viewBox="0 0 24 24"
                                        stroke-width="1.5"
                                        stroke="currentColor"
                                        class="w-8 h-8"
                                        href="/event"
                                    >
                                        <path
                                            stroke-linecap="round"
                                            stroke-linejoin="round"
                                            d="M6.75 3v2.25M17.25 3v2.25M3 18.75V7.5a2.25 2.25 0 012.25-2.25h13.5A2.25 2.25 0 0121 7.5v11.25m-18 0A2.25 2.25 0 005.25 21h13.5A2.25 2.25 0 0021 18.75m-18 0v-7.5A2.25 2.25 0 015.25 9h13.5A2.25 2.25 0 0121 11.25v7.5m-9-6h.008v.008H12v-.008zM12 15h.008v.008H12V15zm0 2.25h.008v.008H12v-.008zM9.75 15h.008v.008H9.75V15zm0 2.25h.008v.008H9.75v-.008zM7.5 15h.008v.008H7.5V15zm0 2.25h.008v.008H7.5v-.008zm6.75-4.5h.008v.008h-.008v-.008zm0 2.25h.008v.008h-.008V15zm0 2.25h.008v.008h-.008v-.008zm2.25-4.5h.008v.008H16.5v-.008zm0 2.25h.008v.008H16.5V15z"
                                        />
                                    </svg>
                                    <span className="text-[15px] font-normal">
                                        Event
                                    </span>
                                </NavLink>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

        
            {header && (
                <header className="bg-white">
                     <div className=" mx-auto py-6 px-4 sm:px-6 lg:px-8">
                        {header}
                     </div>
                </header>
             )}

            {children}
        </div>
    );
}
