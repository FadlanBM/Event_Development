import { Link } from '@inertiajs/react';

export default function NavLink({ active = false, className = '', children, ...props }) {
    return (
        <Link
            {...props}
            className={
                "inline-flex items-center text-sm font-medium leading-5 " +
                (active
                    ? "bg-white w-full h-full rounded-[24px] text-[#E65F2B] "
                    : "border-none text-white hover:text-gray-50 focus:text-gray-700 ") +
                className
            }   
        >
            {children}
        </Link>
    );
}
